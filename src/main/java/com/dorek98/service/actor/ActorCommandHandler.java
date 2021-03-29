package com.dorek98.service.actor;

import com.dorek98.dto.ActorRegistration;
import org.springframework.stereotype.Service;


@Service
public interface ActorCommandHandler{

    void save(ActorRegistration actor);

    void update(long id, ActorRegistration actor);
}
