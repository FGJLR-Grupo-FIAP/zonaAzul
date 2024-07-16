package com.tech.challenge.zonaAzul.condutor.controller.exception.handler;

import com.tech.challenge.zonaAzul.condutor.controller.exception.StandardError;
import com.tech.challenge.zonaAzul.condutor.controller.exception.ValidationError;
import com.tech.challenge.zonaAzul.util.exception.DatabaseException;
import com.tech.challenge.zonaAzul.util.exception.NoSuchRecordException;
import com.tech.challenge.zonaAzul.util.exception.ValidationRegisterTicketException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

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

    @ExceptionHandler(ValidationRegisterTicketException.class)
    public ResponseEntity<StandardError> validationTicketError(ValidationRegisterTicketException ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Erro no processamento da compra ou atualização do ticket",
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Erro na validação de argumento",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> genericError(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        final ValidationError error = new ValidationError(
                System.currentTimeMillis(),
                status.value(),
                "Erro de validação",
                ex.getMessage(),
                request.getRequestURI()
        );

        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach( obj -> {
            error.addError(obj.getField(), obj.getDefaultMessage());
        } );

        return ResponseEntity.status(status).body(error);
    }

}
