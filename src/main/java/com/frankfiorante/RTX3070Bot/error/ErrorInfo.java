package com.frankfiorante.RTX3070Bot.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorInfo {
    private final String message;
    private final String timestamp;
    private final HttpStatus status;
    private final String endpoint;

    public ErrorInfo(String message, HttpStatus status, String endpoint) {
        this.message = message;
        this.timestamp = new Date().toString();
        this.status = status;
        this.endpoint = endpoint;
    }
}
