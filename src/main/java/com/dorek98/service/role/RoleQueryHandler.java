package com.dorek98.service.role;

import com.dorek98.dto.role.RoleDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleQueryHandler {

    List<RoleDetails> findAll();

    ResponseEntity<RoleDetails> findById(long id);

    ResponseEntity<List<RoleDetails>> findByName(String name);

}
