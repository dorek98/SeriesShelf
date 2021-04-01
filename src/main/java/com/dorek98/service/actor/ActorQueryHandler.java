package com.dorek98.service.actor;

import com.dorek98.dto.ActorDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorQueryHandler {

    List<ActorDetails> findAll();

    ActorDetails findById(long id);

    List<ActorDetails> findAdults();

}
