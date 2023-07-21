package com.project.programmingQuiz.ExceptionHandler;

public class QuestionNotFound extends RuntimeException{
    public QuestionNotFound(String message) {
        super(message);
    }

    public QuestionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionNotFound(Throwable cause) {
        super(cause);
    }
}
