package com.project.programmingQuiz.ExceptionHandler;

public class NegativeQuestionId extends RuntimeException{

    public NegativeQuestionId(String message) {
        super(message);
    }

    public NegativeQuestionId(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeQuestionId(Throwable cause) {
        super(cause);
    }
}
