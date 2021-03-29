package com.dorek98.controller;

import com.dorek98.dto.RoleDetails;
import com.dorek98.dto.RoleRegistration;
import com.dorek98.service.role.RoleCommandHandlerImpl;
import com.dorek98.service.role.RoleQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seriesshelf/roles")
@AllArgsConstructor
public class RoleController {

    private final RoleCommandHandlerImpl commandHandler;
    private final RoleQueryHandlerImpl queryHandler;

    @GetMapping
    public List<RoleDetails> getRoles() {
        return queryHandler.findAll();
    }

    @GetMapping("/{id}")
    public RoleDetails getById(@PathVariable long id) {
        return queryHandler.findById(id);
    }

    @PostMapping
    public void create(final RoleRegistration roleRegistration) {
        commandHandler.save(roleRegistration);
    }

    @PutMapping("/{id}")
    public void updateRoleName(long id, String roleName){
        commandHandler.updateRoleName(id,roleName);
    }
}
