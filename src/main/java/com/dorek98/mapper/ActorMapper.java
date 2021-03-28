package com.dorek98.mapper;

import com.dorek98.dto.ActorDto;
import com.dorek98.dto.ActorRequest;
import com.dorek98.dto.RoleDto;
import com.dorek98.model.Actor;
import com.dorek98.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActorMapper {

    @Autowired
    private RoleMapper roleMapper;

    public Actor createActor(ActorDto actorDto){
        return new Actor(actorDto.getFirstName(),actorDto.getLastName(),actorDto.getAge());
    }

    public ActorDto createActorDto(Actor actor){
        return new ActorDto(actor.getActor_id(), actor.getFirstName(), actor.getLastName(), actor.getAge(), roleMapper.listToDto(actor.getRoles()));
    }

    public Actor actorRequest(ActorRequest actorRequest){
        return new Actor(actorRequest.getFirstName(), actorRequest.getLastName(),actorRequest.getAge());
    }

    public List<ActorDto> listToDto(List<Actor> actors){
        List<ActorDto> actorDtos = new ArrayList<>();
        for(Actor a : actors){
            actorDtos.add(createActorDto(a));
        }
        return actorDtos;
    }
}
