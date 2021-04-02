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
import javax.validation.constraints.NotBlank;
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
        return queryHandler.findById(id).isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/name")
    public ResponseEntity<RoleDetails> getByName(@NotBlank String name) {
        return queryHandler.findByName(name).isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(final @Valid RoleRegistration roleRegistration) {
        commandHandler.save(roleRegistration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDetails> updateRoleName(long id, String roleName) {
        return commandHandler.updateRoleName(id, roleName).isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        return commandHandler.delete(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
