package com.dorek98.dto;

import lombok.Value;

@Value
public class RoleRequest {
    String roleName;
    long seriesId;
    long actorId;
}
