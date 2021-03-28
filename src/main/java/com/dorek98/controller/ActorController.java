package com.dorek98.controller;

import com.dorek98.dto.ActorDto;
import com.dorek98.dto.ActorRequest;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.model.Actor;
import com.dorek98.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seriesshelf/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorService actorService;
    private final ActorMapper actorMapper;

    @GetMapping
    public List<ActorDto> getActors(){
        return actorMapper.listToDto(actorService.getAll());
    }

    @GetMapping("/{id}")
    public ActorDto getById(@PathVariable long id){
        return actorMapper.createActorDto(actorService.getActorById(id));
    }

    @PostMapping
    public Actor create(final ActorRequest request){
        return actorService.save(actorMapper.actorRequest(request));
    }

}
