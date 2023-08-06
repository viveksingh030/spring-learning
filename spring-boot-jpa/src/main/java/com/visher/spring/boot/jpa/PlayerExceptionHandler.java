package com.visher.spring.boot.jpa;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler(PlayerNotFoundException ex, HttpServletRequest req) {

        PlayerErrorResponse error = new PlayerErrorResponse().builder().message(ex.getMessage())
                .path(req.getRequestURI()).statusCode(HttpStatus.NOT_FOUND.value()).
                timestamp(ZonedDateTime.now()).build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
	