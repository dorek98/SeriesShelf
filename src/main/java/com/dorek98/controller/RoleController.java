package com.dorek98.controller;

import com.dorek98.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/seriesshelf/roles")
public class RoleController {

    private final ActorService actorService;

    @GetMapping
    public String check(){
        return "Roles dziala okej";
    }
}
