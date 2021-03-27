package com.dorek98.mapper;

import com.dorek98.dto.ActorDto;
import com.dorek98.model.Actor;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    public Actor createActor(ActorDto actorDto){
        return new Actor(actorDto.getFirstName(),actorDto.getLastName(),actorDto.getAge());
    }

    public ActorDto createActorDto(Actor actor){
        return new ActorDto(actor.getActor_id(), actor.getFirstName(), actor.getLastName(), actor.getAge());
    }
}
