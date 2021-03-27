package com.dorek98.repository;

import com.dorek98.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findByFirstName(String firstName);
}
