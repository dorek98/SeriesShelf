package com.dorek98.service.role;

import com.dorek98.model.Role;
import org.springframework.stereotype.Service;


@Service
public interface RoleCommandHandler {

    void save(Role role);

    void update(long id, Role role);
}
