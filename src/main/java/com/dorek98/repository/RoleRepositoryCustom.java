package com.dorek98.repository;

import com.dorek98.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoryCustom {
    Role findByName(String name);
}
