package com.dorek98.service.role;

import com.dorek98.dto.role.RoleDetails;
import com.dorek98.mapper.RoleMapper;
import com.dorek98.model.Role;
import com.dorek98.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        List<Role> roleList = roleRepository.findAll();
        return roleMapper.toRoleDetailsList(roleList);
    }

    @Override
    public ResponseEntity<RoleDetails> findById(long id) {
        try {
            Role role = roleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            RoleDetails roleDetails = roleMapper.toRoleDetails(role);
            return ResponseEntity.ok(roleDetails);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<RoleDetails> findByName(String name) {
        try {
            Role role = roleRepository.findByRoleName(name).orElseThrow(EntityNotFoundException::new);
            RoleDetails roleDetails = roleMapper.toRoleDetails(role);
            return ResponseEntity.ok(roleDetails);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
