package com.dorek98.service;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.dto.actor.ActorRegistration;
import com.dorek98.model.Actor;
import com.dorek98.repository.ActorRepository;
import com.dorek98.service.actor.ActorCommandHandlerImpl;
import com.dorek98.service.actor.ActorQueryHandlerImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class ActorServiceTest {

    @Autowired
    ActorCommandHandlerImpl actorCommandHandler;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ActorQueryHandlerImpl actorQueryHandler;

    @Test
    public void should_be_able_to_save_actor() {
        //given: We have sample actor
        Actor sampleActor = new Actor("Test", "Test", 25);

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
        Actor sampleActor = new Actor("Test", "Test", 25);
        actorRepository.save(sampleActor);
        long idActor = sampleActor.getActor_id();

        //when: We try to update actor
        ResponseEntity<ActorDetails> updatedActor = actorCommandHandler.update(idActor, new ActorRegistration("Test2", "Test2", 15));

        //then: Actor should be updated
        Assert.assertTrue(updatedActor.getBody() != null);
        Assert.assertEquals(idActor, updatedActor.getBody().getId());
        Assert.assertEquals("Test2", updatedActor.getBody().getFirstName());
        Assert.assertEquals("Test2", updatedActor.getBody().getLastName());
        Assert.assertEquals(15, updatedActor.getBody().getAge());

        //clean
        actorRepository.deleteById(idActor);
    }

    @Test
    public void should_not_be_able_to_find_not_existing_actor() {
        //given: We have not existing id
        long notExistingId = 1000;

        //when: We try to find actor with not existing id
        ResponseEntity<ActorDetails> actor = actorQueryHandler.findById(notExistingId);

        //then: Actor should be null
        Assert.assertNull(actor.getBody());
        Assert.assertEquals(actor.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void should_be_able_to_find_only_adult_actors() {
        //given: We have sample not adult actors saved to database
        Actor sampleActor1 = new Actor("Test1", "Test1", 10);
        actorRepository.save(sampleActor1);
        long idActor1 = sampleActor1.getActor_id();

        Actor sampleActor2 = new Actor("Test2", "Test2", 13);
        actorRepository.save(sampleActor2);
        long idActor2 = sampleActor2.getActor_id();

        Actor adultActor = new Actor("Test2", "Test2", 31);
        actorRepository.save(adultActor);
        long idAdult = adultActor.getActor_id();

        //when: We try to find adult actors
        List<ActorDetails> adultActors = actorQueryHandler.findAdults();

        //then: We should not get actors with age below 18
        Assert.assertFalse(adultActors.stream()
                .anyMatch(a -> (
                        a.getId() == idActor1) || a.getId() == idActor2));

        Assert.assertTrue(adultActors.stream()
                .anyMatch(a -> (a.getId() == idAdult)));
    }
}
