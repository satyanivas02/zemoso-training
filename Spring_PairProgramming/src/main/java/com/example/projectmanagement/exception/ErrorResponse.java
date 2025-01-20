package com.example.projectmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int status;          // HTTP Status Code
    private String message;      // Error Message
    private LocalDateTime timestamp; // Timestamp of the error
}