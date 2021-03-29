package com.dorek98.controller;

import com.dorek98.dto.ActorDetails;
import com.dorek98.dto.ActorRegistration;
import com.dorek98.service.actor.ActorCommandHandlerImpl;
import com.dorek98.service.actor.ActorQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ActorDetails getById(@PathVariable long id) {
        return queryHandler.findById(id);
    }

    @PostMapping
    public void create(final ActorRegistration actorRegistration) {
        commandHandler.save(actorRegistration);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, final ActorRegistration actorRegistration){
        commandHandler.update(id, actorRegistration);
    }

}
