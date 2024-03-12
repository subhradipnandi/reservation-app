package com.reservationapp.exception.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityExistsException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException e,
//            WebRequest webRequest
//    ) {
//        // Extracting field errors and constructing response map
//        Map<String, String> responseError = new HashMap<>();
//        e.getBindingResult().getFieldErrors().forEach(error -> responseError.put(error.getField(), error.getDefaultMessage()));
//
//        // Returning bad request status with response map
//        return ResponseEntity.badRequest().body(responseError);
//    }
//
//    @ExceptionHandler({EntityExistsException.class, DataIntegrityViolationException.class})
//    public ResponseEntity<Map<String, String>> handleUniqueConstraintViolation(
//            Exception e,
//            WebRequest webRequest
//            ) {
//        Map<String, String> response = new HashMap<>();
//        response.put("error", "Unique constraint violation");
//        response.put("message", "this have to be unique"); // Optional: Provide more details about the error
//        response.put("uri", webRequest.getDescription(true));
//
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

}
