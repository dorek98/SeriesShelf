package com.dorek98.service.actor;

import com.dorek98.dto.ActorDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ActorQueryHandler {

    List<ActorDetails> findAll();

    Optional<ActorDetails> findById(long id);

    List<ActorDetails> findAdults();

}
