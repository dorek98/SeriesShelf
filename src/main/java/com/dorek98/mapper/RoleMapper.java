package com.dorek98.mapper;

import com.dorek98.dto.ActorDto;
import com.dorek98.dto.RoleDto;
import com.dorek98.dto.SeriesDto;
import com.dorek98.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    @Autowired
    ActorMapper actorMapper;

    @Autowired
    SeriesMapper seriesMapper;

    public Role createRole(RoleDto roleDto, SeriesDto seriesDto, ActorDto actorDto){
        return new Role(roleDto.getRoleName(),seriesMapper.createSeries(seriesDto),actorMapper.createActor(actorDto));
    }

    public RoleDto createRoleDto(Role role){
        return new RoleDto(role.getRole_id(),role.getRoleName(),seriesMapper.createSeriesDto(role.getSeries()),actorMapper.createActorDto(role.getActor()));
    }
}
