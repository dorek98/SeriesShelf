package com.dorek98.service.role;

import com.dorek98.model.Role;
import com.dorek98.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class RoleCommandHandlerImpl implements RoleCommandHandler {

    private final RoleRepository roleRepository;

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void update(long id, Role role) {
        Role oldRole = roleRepository.getOne(id);
        oldRole.setActor(role.getActor());
        oldRole.setRoleName(role.getRoleName());
        oldRole.setSeries(role.getSeries());
        save(oldRole);
    }
}
