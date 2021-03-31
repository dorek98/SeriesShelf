package com.dorek98.repository;

import com.dorek98.model.Actor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepositoryCustom {
    List<Actor> findAdultActors();
}
