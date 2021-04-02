package com.dorek98.service.actor;

import com.dorek98.dto.ActorDetails;
import com.dorek98.dto.ActorRegistration;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.model.Actor;
import com.dorek98.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class ActorCommandHandlerImpl implements ActorCommandHandler {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public void save(ActorRegistration actor) {
        actorRepository.save(actorMapper.createActor(actor));
    }

    @Override
    public Optional<ActorDetails> update(long id, ActorRegistration actor) {
        try {
            Actor oldActor = actorRepository.getOne(id);
            oldActor.setFirstName(actor.getFirstName());
            oldActor.setLastName(actor.getLastName());
            oldActor.setAge(actor.getAge());
            return Optional.of(actorMapper.createActorDetails(actorRepository.save(oldActor)));
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }
}
