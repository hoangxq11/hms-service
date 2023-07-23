package com.hms.demo.web.dto.response.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse extends Response {
    
    private final String errKey;

    public ErrorResponse(String errKey, String message) {
        this.errKey = errKey;
        this.message = message;
    }

    public static ErrorResponse of(String errKey, String details) {
        return new ErrorResponse(errKey, details);
    }
}
