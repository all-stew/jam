package com.zhaojj11.jam.user.api.grpc;

import com.zhaojj11.jam.grpctest.GrpcTestExtension;
import com.zhaojj11.jam.grpctest.ManagedChannelCleanupRegistry;
import com.zhaojj11.jam.grpctest.ServerCleanupRegistry;
import com.zhaojj11.jam.protobuf.user.v1.GetUserInfoByUsernameRequest;
import com.zhaojj11.jam.protobuf.user.v1.UserServiceGrpc;
import com.zhaojj11.jam.user.domain.repository.UserRepository;
import com.zhaojj11.jam.user.service.UserService;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(GrpcTestExtension.class)
@ExtendWith(SpringExtension.class)
public final class UserGrpcServiceTest {

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserService userService;
    private UserServiceGrpc.UserServiceBlockingStub blockingService;

    /**
     * 创建server.
     * @param info test info
     * @param serverRegistry server
     * @param channelRegistry channel
     * @throws Exception e
     */
    @BeforeEach
    public void setUp(
        final TestInfo info, final ServerCleanupRegistry serverRegistry,
        final ManagedChannelCleanupRegistry channelRegistry
    ) throws Exception {
        UserGrpcService service =
            new UserGrpcService(userService, userRepository);

        Server server = serverRegistry.register(
            InProcessServerBuilder.forName(info.getDisplayName())
                .addService(service)
                .build()
        );
        server.start();

        ManagedChannel channel = channelRegistry.register(
            InProcessChannelBuilder.forName(info.getDisplayName())
                .usePlaintext()
                .build()
        );

        blockingService = UserServiceGrpc.newBlockingStub(channel);
    }

    /**
     * 测试返回null.
     */
    @Test
    public void testGetUserInfoByUsernameReturnNull() {
        Mockito.when(
            userService.getLoginUserByUsername(
                ArgumentMatchers.any(String.class)
            )
        ).thenReturn(null);
        GetUserInfoByUsernameRequest request =
            GetUserInfoByUsernameRequest.newBuilder()
                .setUsername("test")
                .build();

        StatusRuntimeException statusRuntimeException =
            Assertions.assertThrows(
                StatusRuntimeException.class, () -> {
                    blockingService.getUserInfoByUsername(request);
                });
        Assertions.assertEquals(
            Status.NOT_FOUND, statusRuntimeException.getStatus()
        );
    }
}
