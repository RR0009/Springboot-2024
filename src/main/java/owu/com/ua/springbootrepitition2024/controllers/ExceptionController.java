package owu.com.ua.springbootrepitition2024.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> myExceptionHandler(MethodArgumentNotValidException e){
        String message = e.getFieldError().getDefaultMessage();
        return new ResponseEntity<>(message, HttpStatusCode.valueOf(500));


    }
}
