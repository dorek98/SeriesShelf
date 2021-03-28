package com.dorek98.service;

import com.dorek98.model.Role;
import com.dorek98.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRole(long id) {
        return roleRepository.getOne(id);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
