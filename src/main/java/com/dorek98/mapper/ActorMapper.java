package com.dorek98.mapper;

import com.dorek98.dto.ActorDetails;
import com.dorek98.dto.ActorRegistration;
import com.dorek98.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActorMapper {

    @Autowired
    private RoleMapper roleMapper;

    public ActorDetails createActorDetails(Actor actor) {
        return new ActorDetails(actor.getActor_id(), actor.getFirstName(), actor.getLastName(), actor.getAge(), roleMapper.listToDetails(actor.getRoles()));
    }

    public Actor createActor(ActorRegistration actor) {
        return new Actor(actor.getFirstName(), actor.getLastName(), actor.getAge());
    }

    public List<ActorDetails> listToDetails(List<Actor> actors) {
        List<ActorDetails> actorsDetails = new ArrayList<>();
        for (Actor a : actors) {
            actorsDetails.add(createActorDetails(a));
        }
        return actorsDetails;
    }
}
