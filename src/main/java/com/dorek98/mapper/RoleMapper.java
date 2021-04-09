package com.dorek98.mapper;

import com.dorek98.dto.role.RoleDetails;
import com.dorek98.dto.role.RoleRegistration;
import com.dorek98.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(final RoleRegistration role);

    @Mapping(target = "id", source = "roleId")
    @Mapping(target = "roleName", source = "roleName")
    RoleDetails toRoleDetails(final Role role);

    List<RoleDetails> toRoleDetailsList(final List<Role> roleList);
}
