package com.dorek98.service.role;

import com.dorek98.dto.role.RoleDetails;

import java.util.List;
import java.util.Optional;

public interface RoleQueryHandler {

    List<RoleDetails> findAll();

    Optional<RoleDetails> findById(long id);

    Optional<RoleDetails> findByName(String name);

}
