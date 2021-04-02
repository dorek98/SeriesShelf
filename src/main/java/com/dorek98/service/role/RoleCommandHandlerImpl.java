package com.dorek98.service.role;

import com.dorek98.dto.RoleDetails;
import com.dorek98.dto.RoleRegistration;
import com.dorek98.mapper.RoleMapper;
import com.dorek98.model.Role;
import com.dorek98.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class RoleCommandHandlerImpl implements RoleCommandHandler {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public void save(RoleRegistration role) {
        roleRepository.save(roleMapper.createRole(role));
    }

    @Override
    public Optional<RoleDetails> updateRoleName(long id, String roleName) {
        try {
            Role role = roleRepository.getOne(id);
            role.setRoleName(roleName);
            return Optional.of(roleMapper.createRoleDetails(roleRepository.save(role)));
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

    public boolean delete(long id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (EntityNotFoundException ex) {
            return false;
        }
    }
}
