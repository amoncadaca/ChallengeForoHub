package com.alura.forohub.forohub.dto;

import javax.validation.constraints.NotBlank;

public class TopicUpdateDTO {

    @NotBlank
    private String message;

    @NotBlank
    private String course;

    // Getters and Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
