package com.dorek98.mapper;

import com.dorek98.dto.RoleDetails;
import com.dorek98.dto.RoleRegistration;
import com.dorek98.model.Role;
import com.dorek98.repository.ActorRepository;
import com.dorek98.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    SeriesRepository seriesRepository;

    public RoleDetails createRoleDetails(Role role) {

        return new RoleDetails(role.getRole_id(), role.getRoleName(), role.getSeries().getSeries_id(), role.getActor().getActor_id());
    }

    public Role createRole(RoleRegistration role) {
        return new Role(role.getRoleName(), seriesRepository.getOne(role.getSeriesId()), actorRepository.getOne(role.getActorId()));
    }

    public List<RoleDetails> listToDetails(List<Role> roles) {
        List<RoleDetails> rolesDetails = new ArrayList<>();
        for (Role r : roles) {
            rolesDetails.add(createRoleDetails(r));
        }
        return rolesDetails;
    }
}
