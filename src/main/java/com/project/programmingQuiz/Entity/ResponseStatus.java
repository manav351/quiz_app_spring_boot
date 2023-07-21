package com.project.programmingQuiz.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ResponseStatus {
    private Boolean success;
    private String message;
    private String error;
}
