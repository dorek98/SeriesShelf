package com.dorek98.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class RoleRegistration {
    @NotBlank
    String roleName;
    @NotNull
    long seriesId;
    @NotNull
    long actorId;
}
