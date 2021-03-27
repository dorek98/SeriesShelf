package com.dorek98.dto;

import lombok.Value;

import java.util.List;

@Value
public class ActorDto {

    long id;
    String firstName;
    String lastName;
    int Age;
    //List<RoleDto> roles;
}
