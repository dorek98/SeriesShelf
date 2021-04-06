package com.dorek98.service.actor;

import com.dorek98.dto.actor.ActorDetails;

import java.util.List;
import java.util.Optional;

public interface ActorQueryHandler {

    List<ActorDetails> findAll();

    Optional<ActorDetails> findById(long id);

    List<ActorDetails> findAdults();

}
