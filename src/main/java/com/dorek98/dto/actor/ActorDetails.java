package com.dorek98.dto.actor;

import com.dorek98.dto.role.RoleDetails;
import lombok.Value;

import java.util.List;

@Value
public class ActorDetails {

    long id;
    String firstName;
    String lastName;
    int age;
    List<RoleDetails> roles;
}
