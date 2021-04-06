package com.dorek98.service.role;

import com.dorek98.dto.role.RoleDetails;
import com.dorek98.dto.role.RoleRegistration;

import java.util.Optional;


public interface RoleCommandHandler {

    void save(RoleRegistration role);

    Optional<RoleDetails> updateRoleName(long id, String roleName);
}
