package com.zhaojj11.jam.user.api.grpc;

import com.zhaojj11.jam.protobuf.user.v1.GetTestRequest;
import com.zhaojj11.jam.protobuf.user.v1.GetTestResponse;
import com.zhaojj11.jam.protobuf.user.v1.UserServiceGrpc.UserServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * UserGrpcService.
 */
@GrpcService
public final class UserGrpcService extends UserServiceImplBase {

    @Override
    public void getTest(
        final GetTestRequest request,
        final StreamObserver<GetTestResponse> responseObserver
    ) {

        responseObserver.onNext(GetTestResponse.newBuilder().setId(1).build());
        responseObserver.onCompleted();
    }
}
