package com.dorek98.controller;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.dto.actor.ActorRegistration;
import com.dorek98.service.actor.ActorCommandHandlerImpl;
import com.dorek98.service.actor.ActorQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/series-shelf/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorCommandHandlerImpl commandHandler;
    private final ActorQueryHandlerImpl queryHandler;

    @GetMapping
    public List<ActorDetails> getActors() {
        return queryHandler.findAll();
    }

    @GetMapping("/adults")
    public List<ActorDetails> getAdultActors() {
        return queryHandler.findAdults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDetails> getById(@PathVariable long id) {
        return queryHandler.findById(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(final @Valid ActorRegistration actorRegistration) {
        commandHandler.save(actorRegistration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorDetails> update(@PathVariable long id, final @Valid ActorRegistration actorRegistration) {
        return commandHandler.update(id, actorRegistration);
    }
}

