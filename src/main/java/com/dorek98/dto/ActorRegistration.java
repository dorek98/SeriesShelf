package com.dorek98.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Value
public class ActorRegistration {

    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @Positive
    @NotNull
    int age;
}
