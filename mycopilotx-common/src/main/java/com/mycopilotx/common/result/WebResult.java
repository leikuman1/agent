package com.mycopilotx.common.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * 统一 Web 响应结果。
 *
 * @param code    响应码
 * @param message 响应信息
 * @param traceId 链路追踪 ID
 * @param data    响应数据
 * @param <T>     响应数据类型
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public record WebResult<T>(
        Integer code,
        String message,
        String traceId,
        T data
) {

    /**
     * 使用当前 MDC 中的 traceId 创建响应。
     */
    public WebResult(Integer code, String message, T data) {
        this(code, message, MDC.get("traceId"), data);
    }

    public static <T> WebResult<T> success(T data) {
        return new WebResult<>(ResponseCode.RESPONSE_SUCCESS.getValue(), null, data);
    }

    public static <T> WebResult<T> success() {
        return new WebResult<>(ResponseCode.RESPONSE_SUCCESS.getValue(), null, null);
    }

    public static <T> WebResult<T> error(Integer code, String message) {
        return new WebResult<>(code, message, null);
    }

    public static <T> WebResult<T> error(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return error(ResponseCode.SYSTEM_ERROR.getValue(), ResponseCode.SYSTEM_ERROR.getMsg());
    }
}
