package com.dorek98.service.role;

import com.dorek98.dto.RoleDetails;
import com.dorek98.dto.RoleRegistration;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface RoleCommandHandler {

    void save(RoleRegistration role);

    Optional<RoleDetails> updateRoleName(long id, String roleName);
}
