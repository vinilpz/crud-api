package com.example.crudexemplesprint4.exception.badrequest;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class BadRequestExcpetionDetails {
    private String title;
    private int status;
    private String details;
    private String msg;
    private LocalDateTime timestamp;
}
