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
import java.util.Optional;

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
            Optional<Actor> actor = actorRepository.findById(roleDTO.getActorId());
            Optional<Series> series = seriesRepository.findById(roleDTO.getSeriesId());
            Role role = roleMapper.toRole(roleDTO);
            role.setActor(actor.get());
            role.setSeries(series.get());
            roleRepository.save(role);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Optional<RoleDetails> updateRoleName(long id, String roleName) {
        try {
            Role role = roleRepository.getOne(id);
            role.setRoleName(roleName);
            return Optional.of(roleMapper.toRoleDetails(roleRepository.save(role)));
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
