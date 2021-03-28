package com.dorek98.mapper;

import com.dorek98.dto.RoleDto;
import com.dorek98.dto.RoleRequest;
import com.dorek98.model.Role;
import com.dorek98.service.ActorService;
import com.dorek98.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {

    @Autowired
    SeriesService seriesService;

    @Autowired
    ActorService actorService;

    public RoleDto createRoleDto(Role role) {
        return new RoleDto(role.getRole_id(), role.getRoleName(), role.getSeries().getSeries_id(), role.getActor().getActor_id());
    }

    public Role createRole(RoleRequest request) {
        return new Role(request.getRoleName(), seriesService.getSeriesById(request.getSeriesId()), actorService.getActorById(request.getActorId()));
    }

    public List<RoleDto> listToDto(List<Role> roles) {
        List<RoleDto> roleDtos = new ArrayList<>();
        for (Role r : roles) {
            roleDtos.add(createRoleDto(r));
        }
        return roleDtos;
    }
}
