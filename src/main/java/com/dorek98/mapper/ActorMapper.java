package com.dorek98.mapper;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.dto.actor.ActorRegistration;
import com.dorek98.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface ActorMapper {

    Actor toActor(final ActorRegistration actor);

    @Mapping(target = "id", source = "actorId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "roles", source = "roles")
    ActorDetails toActorDetails(final Actor actor);

    List<ActorDetails> toActorDetailsList(final List<Actor> actorList);

}
