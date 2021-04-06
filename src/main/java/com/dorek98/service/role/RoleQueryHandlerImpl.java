package com.dorek98.service.role;

import com.dorek98.dto.role.RoleDetails;
import com.dorek98.mapper.RoleMapper;
import com.dorek98.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class RoleQueryHandlerImpl implements RoleQueryHandler {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDetails> findAll() {
        return roleMapper.toDetailsList(roleRepository.findAll());
    }

    @Override
    public Optional<RoleDetails> findById(long id) {
        try {
            return Optional.of(roleMapper.toRoleDetails(roleRepository.getOne(id)));
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<RoleDetails> findByName(String name) {
        try {
            return Optional.of(roleMapper.toRoleDetails(roleRepository.findByName(name)));
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }
}
