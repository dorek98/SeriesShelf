package com.dorek98.service.actor;

import com.dorek98.dto.ActorDetails;
import com.dorek98.dto.ActorRegistration;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface ActorCommandHandler {

    void save(ActorRegistration actor);

    Optional<ActorDetails> update(long id, ActorRegistration actor);
}
