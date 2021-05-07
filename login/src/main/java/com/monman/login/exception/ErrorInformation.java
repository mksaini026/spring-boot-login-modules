package com.monman.login.exception;

public class ErrorInformation {
    private String uri;
    private String message;
    private int status;

    public ErrorInformation(int status, String s, String requestURI) {
        this.status = status;
        this.message = s;
        this.uri = requestURI;
    }
}

