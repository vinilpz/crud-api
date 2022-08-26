package com.crudexemplo.Crud.exception.notfound;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String msg;
    private LocalDateTime timestamp;
}
