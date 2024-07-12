package com.tech.challenge.zonaAzul.condutor.controller.exception.handler;

import com.tech.challenge.zonaAzul.condutor.controller.exception.StandardError;
import com.tech.challenge.zonaAzul.util.exception.DatabaseException;
import com.tech.challenge.zonaAzul.util.exception.NoSuchRecordException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class CustomizedResponseExceptionHandler {

    @ExceptionHandler(NoSuchRecordException.class)
    public ResponseEntity<StandardError> noSuchRecordException(NoSuchRecordException ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.NOT_FOUND;
        final StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Recurso não encontrado",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> validation(HttpMessageNotReadableException ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Erro não previsto no processamento",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> errorDatabase(DatabaseException ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Erro ao tentar executar operação no banco de dados",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> genericError(Exception ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        final StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Erro",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

}
