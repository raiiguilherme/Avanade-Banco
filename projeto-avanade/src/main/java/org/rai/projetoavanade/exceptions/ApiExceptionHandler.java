package org.rai.projetoavanade.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.rai.projetoavanade.exceptions.ex.AccountAlreadyExissts;
import org.rai.projetoavanade.exceptions.ex.BirthdayNotEnough;
import org.rai.projetoavanade.exceptions.ex.DataNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.zip.DataFormatException;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> camposInvalidos(MethodArgumentNotValidException ex, HttpServletRequest request, BindingResult result) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, "Invalid fields", result));
    }

    @ExceptionHandler(AccountAlreadyExissts.class)
    public ResponseEntity<MessageError> customerNotFound(AccountAlreadyExissts ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }

    @ExceptionHandler(DataNotFound.class)
    public ResponseEntity<MessageError> customerNotFound(DataNotFound ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(BirthdayNotEnough.class)
    public ResponseEntity<MessageError> customerNotFound(BirthdayNotEnough ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MessageError(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
    }


}
