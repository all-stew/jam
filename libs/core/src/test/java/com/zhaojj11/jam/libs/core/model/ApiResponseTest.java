package com.zhaojj11.jam.libs.core.model;

import com.zhaojj11.jam.libs.core.enums.ApiResultCodeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ApiResponseTest {
    @Test
    void testOK() {
        ApiResponse<Object> ok = ApiResponse.ok();
        Assertions.assertEquals(ApiResultCodeEnum.SUCCESS.getCode(), ok.getCode());
        Assertions.assertTrue(ok.getSuccess());

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        ApiResponse<ArrayList<Integer>> okWithData = ApiResponse.ok(integerList);
        Assertions.assertEquals(ApiResultCodeEnum.SUCCESS.getCode(), okWithData.getCode());
        Assertions.assertTrue(okWithData.getSuccess());
        Assertions.assertEquals(ArrayList.class, okWithData.getData().getClass());
        Assertions.assertEquals(1, okWithData.getData().size());
    }

    @Test
    void testFail() {
        ApiResponse<Object> fail = ApiResponse.fail("fail");
        Assertions.assertEquals(ApiResultCodeEnum.FAILED.getCode(), fail.getCode());
        Assertions.assertFalse(fail.getSuccess());
        Assertions.assertEquals("fail", fail.getMsg());

        ApiResponse<Object> failWithCode = ApiResponse.fail(401, "fail");
        Assertions.assertFalse(failWithCode.getSuccess());
        Assertions.assertEquals("fail", failWithCode.getMsg());
        Assertions.assertEquals(401, failWithCode.getCode());
    }

    @Test
    void testBuild() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        ApiResponse<ArrayList<Integer>> apiResponse = new ApiResponse<>(true, 300, "hello", integerList);
        Assertions.assertEquals(300, apiResponse.getCode());
        Assertions.assertTrue(apiResponse.getSuccess());
        Assertions.assertEquals(ArrayList.class, apiResponse.getData().getClass());
        Assertions.assertEquals(1, apiResponse.getData().size());
    }
}