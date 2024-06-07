package com.zhaojj11.jam.user.api.grpc;

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
import io.grpc.testing.GrpcCleanupRule;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public final class UserGrpcServiceTest {

    /**
     * 等待时间常量.
     */
    private static final int WAITING_SECONDS = 30;
    //    @Rule
    /**
     * 需要优化@Rule.
     */
    private final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();
    /**
     * server.
     */
    private Server server;
    /**
     * inProcessChannel.
     */
    private ManagedChannel inProcessChannel;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserService userService;

    /**
     * 创建server.
     *
     * @throws Exception e
     */
    @BeforeEach
    public void setUp() throws Exception {
        // Generate a unique in-process server name.
        String serverName = InProcessServerBuilder.generateName();

        InProcessServerBuilder inProcessServerBuilder =
            InProcessServerBuilder.forName(serverName).directExecutor();
        UserGrpcService service =
            new UserGrpcService(userService, userRepository);

        server = inProcessServerBuilder
            .addService(service)
            .build();

        server.start();
        inProcessChannel = grpcCleanup
            .register(
                InProcessChannelBuilder.forName(serverName)
                    .directExecutor()
                    .build()
            );
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

        UserServiceGrpc.UserServiceBlockingStub stub =
            UserServiceGrpc.newBlockingStub(inProcessChannel);

        StatusRuntimeException statusRuntimeException =
            Assertions.assertThrows(
                StatusRuntimeException.class, () -> {
                    stub.getUserInfoByUsername(request);
                });
        Assertions.assertEquals(
            Status.NOT_FOUND, statusRuntimeException.getStatus()
        );
    }

    /**
     * 关闭.
     *
     * @throws Exception e
     */
    @AfterEach
    public void tearDown() throws Exception {
        if (server != null) {
            server.shutdown()
                .awaitTermination(WAITING_SECONDS, TimeUnit.SECONDS);
        }
    }
}
