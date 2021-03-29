package com.dorek98.service.role;

import com.dorek98.dto.RoleRegistration;
import org.springframework.stereotype.Service;


@Service
public interface RoleCommandHandler {

    void save(RoleRegistration role);

    void updateRoleName(long id, String roleName);
}
