package com.dorek98.service.role;

import com.dorek98.dto.RoleDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleQueryHandler {

    List<RoleDetails> findAll();

    RoleDetails findById(long id);

    //TODO: Actor findByName(String firstName);
}
