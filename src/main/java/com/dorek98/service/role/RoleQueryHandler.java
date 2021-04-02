package com.dorek98.service.role;

import com.dorek98.dto.RoleDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleQueryHandler {

    List<RoleDetails> findAll();

    Optional<RoleDetails> findById(long id);

    Optional<RoleDetails> findByName(String name);

}
