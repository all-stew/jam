package com.zhaojj11.jam.user.api.grpc;

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
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户管理服务 grpc.
 */
@GrpcService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class UserManagementGrpcService extends UserManagementServiceImplBase {

    @Override
    public void page(
        final PageRequest request,
        final StreamObserver<PageReponse> responseObserver
    ) {
        responseObserver.onNext(
            PageReponse.newBuilder().addAllUsers(new ArrayList<>()).build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void getById(
        final GetByIdRequest request,
        final StreamObserver<GetByIdResponse> responseObserver
    ) {
        responseObserver.onNext(
            GetByIdResponse.newBuilder().build()
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
