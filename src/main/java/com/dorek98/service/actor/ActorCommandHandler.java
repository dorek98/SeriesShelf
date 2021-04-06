package com.dorek98.service.actor;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.dto.actor.ActorRegistration;

import java.util.Optional;


public interface ActorCommandHandler {

    void save(ActorRegistration actor);

    Optional<ActorDetails> update(long id, ActorRegistration actor);
}
