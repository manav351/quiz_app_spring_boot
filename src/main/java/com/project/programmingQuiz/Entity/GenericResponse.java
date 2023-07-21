package com.project.programmingQuiz.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GenericResponse {
    private ResponseStatus status;
    private Question data;
}
