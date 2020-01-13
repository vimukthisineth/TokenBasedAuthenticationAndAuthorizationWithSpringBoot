package com.prolific.software.foodappbackend.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseWrapper {

    private Status status;
    private String message;
    private String responseCode;
    private Object body;

    public enum Status {
        SUCCESS,
        FAILURE
    }

    public ResponseWrapper(Status status) {
        this.status = status;
    }

    public ResponseWrapper(Status status, Object body) {
        this.status = status;
        this.body = body;
    }

    @JsonIgnore
    public static ResponseWrapper success() {
        return new ResponseWrapper(Status.SUCCESS);
    }

    @JsonIgnore
    public static ResponseWrapper success(Object body) {
        return new ResponseWrapper(Status.SUCCESS, body);
    }

    @JsonIgnore
    public static ResponseWrapper failure() {
        return new ResponseWrapper(Status.FAILURE);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
