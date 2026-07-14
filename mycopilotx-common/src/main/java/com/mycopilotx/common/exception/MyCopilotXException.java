package com.mycopilotx.common.exception;

import com.mycopilotx.common.result.ResponseCode;
import lombok.Getter;

import java.io.Serial;

@Getter
public class MyCopilotXException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final ResponseCode responseCode;

    public MyCopilotXException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.responseCode = responseCode;
    }

    public MyCopilotXException(ResponseCode responseCode, String detail) {
        super(detail);
        this.responseCode = responseCode;
    }
}
