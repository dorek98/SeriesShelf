package com.dorek98.service;

import com.dorek98.model.Actor;
import com.dorek98.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public Actor save(Actor actor){
        return actorRepository.save(actor);
    }

    public List<Actor> getAll(){
        return actorRepository.findAll();
    }

    public String getLastName(String name){
        return actorRepository.findByFirstName(name).getLastName();
    }

    public Actor getActor(String name){
        return actorRepository.findByFirstName(name);
    }
}