package com.dorek98.service.role;

import com.dorek98.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleQueryHandler {

    List<Role> findAll();

    Role findById(long id);

    //TODO: Actor findByName(String firstName);
}
