package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;


@RestControllerAdvice
public class Exceptions  {


    @ExceptionHandler(Exception.class)
    public ProblemDetail allProblemDetail(Exception ex){
        ProblemDetail detail=ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        detail.setProperty("time",LocalDateTime.now());
        detail.setDetail(ex.getMessage());
        return detail;

    }

@ExceptionHandler(NoSuchElementException.class)
    public ProblemDetail problemDetail(NoSuchElementException exception) {
ProblemDetail detail=ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
detail.setProperty("time", LocalDateTime.now());
detail.setDetail(exception.getMessage());
    return detail;
}
}
