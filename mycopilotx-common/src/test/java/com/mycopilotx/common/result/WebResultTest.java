package com.mycopilotx.common.result;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WebResultTest {

    @AfterEach
    void clearMdc() {
        MDC.clear();
    }

    @Test
    void shouldCreateSuccessResultWithDataAndTraceId() {
        MDC.put("traceId", "trace-001");

        WebResult<String> result = WebResult.success("ok");

        assertEquals(ResponseCode.RESPONSE_SUCCESS.getValue(), result.code());
        assertNull(result.message());
        assertEquals("trace-001", result.traceId());
        assertEquals("ok", result.data());
    }

    @Test
    void shouldCreateSuccessResultWithoutData() {
        WebResult<Void> result = WebResult.success();

        assertEquals(ResponseCode.RESPONSE_SUCCESS.getValue(), result.code());
        assertNull(result.data());
    }

    @Test
    void shouldCreateErrorResultWithStableCodeAndMessage() {
        WebResult<Void> result = WebResult.error(
                ResponseCode.MODEL_NOT_FOUND.getValue(),
                ResponseCode.MODEL_NOT_FOUND.getMsg()
        );

        assertEquals(ResponseCode.MODEL_NOT_FOUND.getValue(), result.code());
        assertEquals(ResponseCode.MODEL_NOT_FOUND.getMsg(), result.message());
        assertNull(result.data());
    }

    @Test
    void shouldResolveKnownAndUnknownResponseCodes() {
        assertEquals(ResponseCode.MODEL_NOT_FOUND, ResponseCode.getByCode(6002));
        assertEquals(ResponseCode.CODE_NOT_FOUND, ResponseCode.getByCode(-1));
    }
}
