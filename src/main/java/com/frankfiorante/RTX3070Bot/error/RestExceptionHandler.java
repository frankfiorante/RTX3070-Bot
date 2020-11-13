package com.frankfiorante.RTX3070Bot.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(KeywordNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleKeywordNotFoundException(KeywordNotFoundException e, HttpServletRequest endpoint) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorInfo(e.getMessage(), HttpStatus.NOT_FOUND, "/" + endpoint.getRequestURI().split("/")[1]));
    }
}
