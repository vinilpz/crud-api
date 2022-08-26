package com.crudexemplo.Crud.handler;

import com.crudexemplo.Crud.exception.notfound.NotFoundException;
import com.crudexemplo.Crud.exception.notfound.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> handlerNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<>(
                NotFoundExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Not Found Exception")
                        .details(notFoundException.getMessage())
                        .msg(notFoundException.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);
    }

}
