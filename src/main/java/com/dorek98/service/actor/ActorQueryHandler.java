package com.dorek98.service.actor;

import com.dorek98.dto.actor.ActorDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActorQueryHandler {

    List<ActorDetails> findAll();

    ResponseEntity<ActorDetails> findById(long id);

    List<ActorDetails> findAdults();

}
