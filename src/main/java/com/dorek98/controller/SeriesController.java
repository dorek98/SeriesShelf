package com.dorek98.controller;

import com.dorek98.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seriesshelf/series")
@AllArgsConstructor
public class SeriesController {

    private final SeriesService seriesService;

    @GetMapping
    public String isOk(){
        return " Series dziala okej";
    }
}
