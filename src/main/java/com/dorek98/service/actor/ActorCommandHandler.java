package com.dorek98.service.actor;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.dto.actor.ActorRegistration;
import org.springframework.http.ResponseEntity;


public interface ActorCommandHandler {

    void save(ActorRegistration actor);

    ResponseEntity<ActorDetails> update(long id, ActorRegistration actor);
}
