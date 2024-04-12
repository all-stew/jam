package com.zhaojj11.jam.user.api.grpc;

import com.zhaojj11.jam.protobuf.user.v1.GetTestRequest;
import com.zhaojj11.jam.protobuf.user.v1.GetTestResponse;
import com.zhaojj11.jam.protobuf.user.v1.UserServiceGrpc.UserServiceImplBase;
import io.grpc.stub.StreamObserver;

/**
 * UserGrpcService.
 */
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
