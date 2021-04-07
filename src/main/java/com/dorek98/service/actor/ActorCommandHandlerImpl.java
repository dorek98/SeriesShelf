package com.dorek98.service.actor;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.dto.actor.ActorRegistration;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.model.Actor;
import com.dorek98.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
@Transactional
public class ActorCommandHandlerImpl implements ActorCommandHandler {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public void save(ActorRegistration actorDTO) {
        Actor actor = actorMapper.toActor(actorDTO);
        actorRepository.save(actor);
    }

    @Override
    public ResponseEntity<ActorDetails> update(long id, ActorRegistration actor) {
        try {
            Actor oldActor = actorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            oldActor.setFirstName(actor.getFirstName());
            oldActor.setLastName(actor.getLastName());
            oldActor.setAge(actor.getAge());
            Actor newActor = actorRepository.save(oldActor);
            ActorDetails actorDetails = actorMapper.toActorDetails(newActor);
            return ResponseEntity.ok(actorDetails);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
