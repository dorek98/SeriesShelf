package com.dorek98.service.role;

import com.dorek98.dto.RoleDetails;
import com.dorek98.mapper.RoleMapper;
import com.dorek98.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class RoleQueryHandlerImpl implements RoleQueryHandler {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDetails> findAll() {
        return roleMapper.listToDetails(roleRepository.findAll());
    }

    @Override
    public RoleDetails findById(long id) {
        return roleMapper.createRoleDetails(roleRepository.getOne(id));
    }
}
