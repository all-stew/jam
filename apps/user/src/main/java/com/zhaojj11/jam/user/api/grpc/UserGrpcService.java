package com.zhaojj11.jam.user.api.grpc;

import com.zhaojj11.jam.protobuf.user.v1.CreateUserByRegisterRequest;
import com.zhaojj11.jam.protobuf.user.v1.CreateUserByRegisterResponse;
import com.zhaojj11.jam.protobuf.user.v1.GetUserInfoByUsernameRequest;
import com.zhaojj11.jam.protobuf.user.v1.GetUserInfoByUsernameResponse;
import com.zhaojj11.jam.protobuf.user.v1.UserServiceGrpc.UserServiceImplBase;
import com.zhaojj11.jam.user.domain.dto.LoginUserDto;
import com.zhaojj11.jam.user.domain.model.User;
import com.zhaojj11.jam.user.domain.repository.UserRepository;
import com.zhaojj11.jam.user.domain.transformer.UserTransformer;
import com.zhaojj11.jam.user.service.UserService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserGrpcService.
 */
@GrpcService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserGrpcService extends UserServiceImplBase {

    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public void getUserInfoByUsername(
        final GetUserInfoByUsernameRequest request,
        final StreamObserver<GetUserInfoByUsernameResponse> responseObserver
    ) {
        String username = request.getUsername();

        LoginUserDto userDto = userService.getLoginUserByUsername(username);

        if (userDto == null) {
            responseObserver.onError(Status.NOT_FOUND.asException());
            return;
        }

        responseObserver.onNext(
            GetUserInfoByUsernameResponse.newBuilder()
                .setUserInfo(UserTransformer.toProto(userDto))
                .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void createUserByRegister(
        final CreateUserByRegisterRequest request,
        final StreamObserver<CreateUserByRegisterResponse> responseObserver
    ) {
        String username = request.getUsername();
        String password = request.getPassword();

        if (StringUtils.isNotBlank(username)
            || StringUtils.isNotBlank(password)
        ) {
            responseObserver.onError(
                Status.INVALID_ARGUMENT
                    .withDescription("username or password is empty")
                    .asException()
            );
            return;
        }

        // 注册时需要确保用户名唯一
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            responseObserver.onError(
                Status.INVALID_ARGUMENT
                    .withDescription("user exist")
                    .asException()
            );
            return;
        }

        boolean register = userService.register(username, password);
        responseObserver.onNext(
            CreateUserByRegisterResponse.newBuilder().build()
        );
        responseObserver.onCompleted();
    }
}
