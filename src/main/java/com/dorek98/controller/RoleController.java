package com.dorek98.controller;

import com.dorek98.dto.RoleDto;
import com.dorek98.dto.RoleRequest;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.mapper.RoleMapper;
import com.dorek98.model.Role;
import com.dorek98.service.ActorService;
import com.dorek98.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/seriesshelf/roles")
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @GetMapping
    public List<RoleDto> getRoles(){
        return roleMapper.listToDto(roleService.getAll());
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable long id){
        return roleMapper.createRoleDto(roleService.getRole(id));
    }

    @PostMapping
    public Role create(final RoleRequest request){
        return roleService.save(roleMapper.roleRequest(request));
    }
}
