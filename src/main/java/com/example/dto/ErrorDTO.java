package com.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDTO {

    private String message;
    private LocalDateTime time;
}
