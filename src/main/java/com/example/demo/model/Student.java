package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@JsonSerialize
public class Student implements Serializable {

    @NotBlank
    private Long id;

    @NotBlank
    private final String name;

    public Student(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
