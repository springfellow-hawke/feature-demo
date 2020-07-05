package za.co.sfh.features.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.co.sfh.features.exceptions.ErrorDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ControllerAdviseResolver extends ResponseEntityExceptionHandler {

     /**
      * Handle our custom exception for invalid header received
      *
      * @param ex
      * @param request
      * @return
      */
     @ExceptionHandler({HttpClientErrorException.BadRequest.class})
     protected ResponseEntity<Object> handleInvalidHeaderExceptionException(
             Exception ex, WebRequest request) {
          return new ResponseEntity<Object>(
                  "Invalid header received:", new HttpHeaders(), HttpStatus.FORBIDDEN);
     }

     /**
      * Handle invalid arguments received exception
      */
     @Override
     protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
          List<String> errorList = ex
                  .getBindingResult()
                  .getFieldErrors()
                  .stream()
                  .map(fieldError -> fieldError.getDefaultMessage())
                  .collect(Collectors.toList());
          ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errorList);
          return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
     }

     /**
      * Handle methods not implemented yet...
      */
     @Override
     protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
          ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, "Method not implemented yet", new ArrayList<>());
          return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
     }
}
