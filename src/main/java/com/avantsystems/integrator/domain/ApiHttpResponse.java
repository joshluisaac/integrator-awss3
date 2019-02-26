package com.avantsystems.integrator.domain;

public class ApiHttpResponse {

    private int httpStatus;
    private String message;
    private Object response;

    public ApiHttpResponse(int httpStatus, String message, Object response) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.response = response;
    }
}
