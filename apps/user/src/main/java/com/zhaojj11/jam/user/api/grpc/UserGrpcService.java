package com.zhaojj11.jam.user.api.grpc;

import com.zhaojj11.jam.protobuf.user.v1.GetUserInfoByUsernameRequest;
import com.zhaojj11.jam.protobuf.user.v1.GetUserInfoByUsernameResponse;
import com.zhaojj11.jam.protobuf.user.v1.UserServiceGrpc.UserServiceImplBase;
import com.zhaojj11.jam.user.domain.dto.UserDto;
import com.zhaojj11.jam.user.domain.transformer.UserTransformer;
import com.zhaojj11.jam.user.service.UserService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserGrpcService.
 */
@GrpcService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserGrpcService extends UserServiceImplBase {

    private final UserService userService;

    @Override
    public void getUserInfoByUsername(
        final GetUserInfoByUsernameRequest request,
        final StreamObserver<GetUserInfoByUsernameResponse> responseObserver
    ) {
        String username = request.getUsername();

        UserDto userDto = userService.getByUsername(username);

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
}
