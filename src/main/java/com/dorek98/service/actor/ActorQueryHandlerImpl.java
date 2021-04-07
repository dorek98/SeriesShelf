package com.dorek98.service.actor;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.model.Actor;
import com.dorek98.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class ActorQueryHandlerImpl implements ActorQueryHandler {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public List<ActorDetails> findAll() {
        return actorMapper.toActorDetailsList(actorRepository.findAll());
    }

    @Override
    public Optional<ActorDetails> findById(long id) {
        try {
            Optional<Actor> actor = Optional.ofNullable(actorRepository.findById(id).orElseThrow(EntityNotFoundException::new));
            return Optional.of(actorMapper.toActorDetails(actor.get()));
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<ActorDetails> findAdults() {
        return actorMapper.toActorDetailsList(actorRepository.findAdultActors());
    }
}
