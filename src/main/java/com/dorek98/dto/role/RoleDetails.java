package com.dorek98.dto.role;

import lombok.Value;

@Value
public class RoleDetails {

    long id;
    String roleName;
    long seriesId;
    long actorId;

}
