package com.dorek98.dto;

import lombok.Value;

@Value
public class RoleDto {

    long id;
    String roleName;
    long seriesId;
    long actorId;

}
