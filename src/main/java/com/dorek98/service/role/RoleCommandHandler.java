package com.dorek98.service.role;

import com.dorek98.dto.role.RoleDetails;
import com.dorek98.dto.role.RoleRegistration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public interface RoleCommandHandler {

    ResponseEntity<HttpStatus> save(RoleRegistration role);

    ResponseEntity<RoleDetails> updateRoleName(long id, String roleName);
}
