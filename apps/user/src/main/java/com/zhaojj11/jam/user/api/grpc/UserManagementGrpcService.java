package com.zhaojj11.jam.user.api.grpc;

import com.zhaojj11.jam.libs.jpa.utils.PageUtils;
import com.zhaojj11.jam.protobuf.user.v1.CreateReponse;
import com.zhaojj11.jam.protobuf.user.v1.CreateRequest;
import com.zhaojj11.jam.protobuf.user.v1.GetByIdRequest;
import com.zhaojj11.jam.protobuf.user.v1.GetByIdResponse;
import com.zhaojj11.jam.protobuf.user.v1.PageReponse;
import com.zhaojj11.jam.protobuf.user.v1.PageRequest;
import com.zhaojj11.jam.protobuf.user.v1.ResetPasswordRequest;
import com.zhaojj11.jam.protobuf.user.v1.ResetPasswordResponse;
import com.zhaojj11.jam.protobuf.user.v1.UpdateStatusRequest;
import com.zhaojj11.jam.protobuf.user.v1.UpdateStatusResponse;
import com.zhaojj11.jam.protobuf.user.v1.UserManagementServiceGrpc.UserManagementServiceImplBase;
import com.zhaojj11.jam.user.domain.model.User;
import com.zhaojj11.jam.user.domain.repository.UserRepository;
import com.zhaojj11.jam.user.domain.transformer.UserTransformer;
import com.zhaojj11.jam.user.service.UserService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * 用户管理服务 grpc.
 */
@GrpcService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserManagementGrpcService extends UserManagementServiceImplBase {

    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public void page(
        final PageRequest request,
        final StreamObserver<PageReponse> responseObserver
    ) {
        Page<User> userPage = userRepository.page(request.getUsername(), PageUtils.getPage(request.getPage()));
        responseObserver.onNext(
            PageReponse.newBuilder()
                .addAllUsers(UserTransformer.toProto(userPage.getContent()))
                .setTotal(userPage.getTotalElements())
                .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getById(
        final GetByIdRequest request,
        final StreamObserver<GetByIdResponse> responseObserver
    ) {
        Optional<User> userOptional = userRepository.findById(request.getId());
        if (userOptional.isEmpty()) {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return;
        }
        responseObserver.onNext(
            GetByIdResponse.newBuilder().setUser(UserTransformer.toProto(userOptional.get())).build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void create(
        final CreateRequest request,
        final StreamObserver<CreateReponse> responseObserver
    ) {
        responseObserver.onNext(
            CreateReponse.newBuilder().build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void resetPassword(
        final ResetPasswordRequest request,
        final StreamObserver<ResetPasswordResponse> responseObserver
    ) {
        responseObserver.onNext(
            ResetPasswordResponse.newBuilder().build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void updateStatus(
        final UpdateStatusRequest request,
        final StreamObserver<UpdateStatusResponse> responseObserver
    ) {
        responseObserver.onNext(
            UpdateStatusResponse.newBuilder().build()
        );
        responseObserver.onCompleted();
    }
}
