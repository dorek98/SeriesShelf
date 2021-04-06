package com.dorek98.mapper;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.dto.actor.ActorRegistration;
import com.dorek98.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActorMapper {

    @Autowired
    private RoleMapper roleMapper;

    public ActorDetails toActorDetails(Actor actor) {
        return new ActorDetails(actor.getActor_id(), actor.getFirstName(), actor.getLastName(), actor.getAge(), roleMapper.toDetailsList(actor.getRoles()));
    }

    public Actor toActor(ActorRegistration actor) {
        return new Actor(actor.getFirstName(), actor.getLastName(), actor.getAge());
    }

    public List<ActorDetails> toDetailsList(List<Actor> actors) {
        List<ActorDetails> actorsDetails = new ArrayList<>();
        for (Actor a : actors) {
            actorsDetails.add(toActorDetails(a));
        }
        return actorsDetails;
    }
}
