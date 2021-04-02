package com.dorek98.service;

import com.dorek98.dto.RoleDetails;
import com.dorek98.model.Actor;
import com.dorek98.model.Platform;
import com.dorek98.model.Role;
import com.dorek98.model.Series;
import com.dorek98.repository.ActorRepository;
import com.dorek98.repository.RoleRepository;
import com.dorek98.repository.SeriesRepository;
import com.dorek98.service.role.RoleCommandHandlerImpl;
import com.dorek98.service.role.RoleQueryHandlerImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleCommandHandlerImpl roleCommandHandler;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    RoleQueryHandlerImpl roleQueryHandler;

    @Test
    public void should_be_able_to_save_role() {
        //given: We have sample role
        Actor sampleActor = new Actor("Test", "Test", 20);
        Series sampleSeries = new Series("TestSeries", 1, Platform.HBO, 2021);
        Role sampleRole = new Role("TestRole", sampleSeries, sampleActor);

        //when: We try to save role to database
        actorRepository.save(sampleActor);
        long idActor = sampleActor.getActor_id();
        seriesRepository.save(sampleSeries);
        long idSeries = sampleSeries.getSeries_id();
        roleRepository.save(sampleRole);
        long idRole = sampleRole.getRole_id();

        //then: Role should exist in database
        Assert.assertTrue(roleRepository.existsById(idRole));

        //clean
        roleRepository.deleteById(idRole);
        actorRepository.deleteById(idActor);
        seriesRepository.deleteById(idSeries);
    }

    @Test
    public void should_be_able_to_update_role_name() {
        //given: We have sample series in database
        Actor sampleActor = new Actor("Test", "Test", 20);
        Series sampleSeries = new Series("TestSeries", 1, Platform.HBO, 2021);
        Role sampleRole = new Role("TestRole", sampleSeries, sampleActor);
        actorRepository.save(sampleActor);
        long idActor = sampleActor.getActor_id();
        seriesRepository.save(sampleSeries);
        long idSeries = sampleSeries.getSeries_id();
        roleRepository.save(sampleRole);
        long idRole = sampleRole.getRole_id();

        //when: We try to update role name
        Optional<RoleDetails> updatedRole = roleCommandHandler.updateRoleName(idRole, "newTest");

        //then: Actor should be updated
        Assert.assertTrue(updatedRole.isPresent());
        Assert.assertEquals(idRole, updatedRole.get().getId());
        Assert.assertEquals("newTest", updatedRole.get().getRoleName());
        Assert.assertEquals(idActor, updatedRole.get().getActorId());
        Assert.assertEquals(idSeries, updatedRole.get().getSeriesId());

        //clean
        roleRepository.deleteById(idRole);
        seriesRepository.deleteById(idSeries);
        actorRepository.deleteById(idActor);
    }

    @Test
    public void should_not_be_able_to_find_not_existing_role() {
        //given: We have not existing id
        long notExistingId = 1000;

        //when: We try to find actor with not existing id
        Optional<RoleDetails> role = roleQueryHandler.findById(notExistingId);

        //then: Actor should be null
        Assert.assertTrue(role.isEmpty());
    }
}