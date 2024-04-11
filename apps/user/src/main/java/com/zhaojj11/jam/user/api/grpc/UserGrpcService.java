package com.zhaojj11.jam.user.api.grpc;

import com.zhaojj11.jam.protobuf.user.v1.TestRequest;
import com.zhaojj11.jam.protobuf.user.v1.TestResponse;
import com.zhaojj11.jam.protobuf.user.v1.UserServiceGrpc.UserServiceImplBase;
import io.grpc.stub.StreamObserver;

/**
 * UserGrpcService.
 */
public final class UserGrpcService extends UserServiceImplBase {

    @Override
    public void test(
        final TestRequest request,
        final StreamObserver<TestResponse> responseObserver
    ) {
        super.test(request, responseObserver);
    }
}
