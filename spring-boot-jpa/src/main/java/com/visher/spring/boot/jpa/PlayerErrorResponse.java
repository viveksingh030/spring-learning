package com.visher.spring.boot.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlayerErrorResponse {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime timestamp;
    private int statusCode;
    private String path;
    private String message;


}