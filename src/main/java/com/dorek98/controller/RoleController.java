package com.dorek98.controller;

import com.dorek98.dto.RoleDetails;
import com.dorek98.dto.RoleRegistration;
import com.dorek98.service.role.RoleCommandHandlerImpl;
import com.dorek98.service.role.RoleQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<RoleDetails> getById(@PathVariable long id) {
        return Optional
                .ofNullable(queryHandler.findById(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(final @Valid RoleRegistration roleRegistration) {
        commandHandler.save(roleRegistration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDetails> updateRoleName(long id, String roleName) {
        return Optional
                .ofNullable(commandHandler.updateRoleName(id, roleName))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
