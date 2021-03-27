package com.dorek98.controller;

import com.dorek98.dto.ActorDto;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.model.Actor;
import com.dorek98.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seriesshelf/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorService actorService;
    private final ActorMapper actorMapper;

    @GetMapping
    public List<Actor> isWorking(){
        return actorService.getAll();
    }

    @GetMapping("/{name}")
    public ActorDto getFind(@PathVariable String name){
        return actorMapper.createActorDto(actorService.getActor(name));
    }

}
