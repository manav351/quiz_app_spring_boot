package com.project.programmingQuiz.ExceptionHandler;

import com.project.programmingQuiz.Entity.GenericResponse;
import com.project.programmingQuiz.Entity.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuestionExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(QuestionNotFound exc){
        return new ResponseEntity<>(
                new GenericResponse(
                        new ResponseStatus(false, "Operation Failed", "Question Not found"),
                        null
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(NegativeQuestionId exc){
        return new ResponseEntity<>(
                new GenericResponse(
                        new ResponseStatus(false, "Operation Failed", "Question ID cannot be a negative value"),
                        null
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(RuntimeException exc){
        return new ResponseEntity<>(
                new GenericResponse(
                        new ResponseStatus(false, "Operation Failed", "Bad Request. Please verify the payload!"),
                        null
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
