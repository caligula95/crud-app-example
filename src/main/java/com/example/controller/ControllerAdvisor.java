package com.example.controller;

import com.example.dto.ErrorDTO;
import com.example.exception.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.badRequest().body(ErrorDTO.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(ErrorDTO.builder()
                .message(exception.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(",")))
                .time(LocalDateTime.now())
                .build());
    }
}
