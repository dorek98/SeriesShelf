package com.dorek98.service;

import com.dorek98.dto.ActorDetails;
import com.dorek98.dto.ActorRegistration;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.model.Actor;
import com.dorek98.repository.ActorRepository;
import com.dorek98.service.actor.ActorCommandHandlerImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ActorServiceTest {

    @Autowired
    ActorCommandHandlerImpl actorCommandHandler;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ActorMapper actorMapper;

    @Test
    public void should_be_able_to_save_actor() {
        //given: We have sample actor
        Actor sampleActor = new Actor("Mark", "Leo", 25);

        //when: We try to save actor to database
        actorRepository.save(sampleActor);
        long idActor = sampleActor.getActor_id();
        //then: Actor should exist in database
        Assert.assertTrue(actorRepository.existsById(idActor));

        //clean
        actorRepository.deleteById(idActor);
    }

    @Test
    public void should_be_able_to_update_actor() {
        //given: We have sample actor in database
        Actor sampleActor = new Actor("Mark", "Leo", 25);
        actorRepository.save(sampleActor);
        long idActor = sampleActor.getActor_id();

        //when: We try to update actor
        ActorDetails updatedActor = actorCommandHandler.update(idActor, new ActorRegistration("Tom", "Holl", 15));

        //then: Actor should be updated
        Assert.assertEquals(idActor,updatedActor.getId());
        Assert.assertEquals("Tom", updatedActor.getFirstName());
        Assert.assertEquals("Holl", updatedActor.getLastName());
        Assert.assertEquals(15, updatedActor.getAge());

        //clean
        actorRepository.deleteById(idActor);
    }

}
