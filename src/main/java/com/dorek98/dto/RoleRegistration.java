package com.dorek98.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class RoleRegistration {
    @NotBlank
    String roleName;
    @NotBlank
    long seriesId;
    @NotBlank
    long actorId;
}
