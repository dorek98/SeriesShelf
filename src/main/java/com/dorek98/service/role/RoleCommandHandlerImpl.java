package com.dorek98.service.role;

import com.dorek98.dto.role.RoleDetails;
import com.dorek98.dto.role.RoleRegistration;
import com.dorek98.mapper.RoleMapper;
import com.dorek98.model.Actor;
import com.dorek98.model.Role;
import com.dorek98.model.Series;
import com.dorek98.repository.ActorRepository;
import com.dorek98.repository.RoleRepository;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
@Transactional
public class RoleCommandHandlerImpl implements RoleCommandHandler {

    private final ActorRepository actorRepository;
    private final SeriesRepository seriesRepository;
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public ResponseEntity<HttpStatus> save(RoleRegistration roleDTO) {
        try {
            Actor actor = actorRepository.findById(roleDTO.getActorId()).orElseThrow(EntityNotFoundException::new);
            Series series = seriesRepository.findById(roleDTO.getSeriesId()).orElseThrow(EntityNotFoundException::new);
            Role role = roleMapper.toRole(roleDTO);
            role.setActor(actor);
            role.setSeries(series);
            roleRepository.save(role);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<RoleDetails> updateRoleName(long id, String roleName) {
        try {
            Role role = roleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            role.setRoleName(roleName);
            Role newRole = roleRepository.save(role);
            RoleDetails roleDetails = roleMapper.toRoleDetails(newRole);
            return ResponseEntity.ok(roleDetails);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<HttpStatus> delete(long id) {
        try {
            roleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
