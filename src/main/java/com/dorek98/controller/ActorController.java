package com.dorek98.controller;

import com.dorek98.dto.ActorDetails;
import com.dorek98.dto.ActorRegistration;
import com.dorek98.service.actor.ActorCommandHandlerImpl;
import com.dorek98.service.actor.ActorQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seriesshelf/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorCommandHandlerImpl commandHandler;
    private final ActorQueryHandlerImpl queryHandler;

    @GetMapping
    public List<ActorDetails> getActors() {
        return queryHandler.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDetails> getById(@PathVariable long id) {
        return Optional
                .ofNullable(queryHandler.findById(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(final @Valid ActorRegistration actorRegistration) {
        commandHandler.save(actorRegistration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorDetails> update(@PathVariable long id, final ActorRegistration actorRegistration) {
        return Optional
                .ofNullable(commandHandler.update(id, actorRegistration))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
