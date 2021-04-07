package com.dorek98.dto.role;

import com.dorek98.model.Actor;
import com.dorek98.model.Series;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RoleDetails {

    long role_id;
    String roleName;
    long seriesId;
    long actorId;

    public RoleDetails(long id, String roleName, Series series, Actor actor) {
        this.role_id = id;
        this.roleName = roleName;
        this.seriesId = series.getSeries_id();
        this.actorId = actor.getActor_id();
    }
}
