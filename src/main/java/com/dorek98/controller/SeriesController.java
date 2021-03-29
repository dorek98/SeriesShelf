package com.dorek98.controller;

import com.dorek98.dto.SeriesDetails;
import com.dorek98.dto.SeriesRegistration;
import com.dorek98.service.series.SeriesCommandHandlerImpl;
import com.dorek98.service.series.SeriesQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seriesshelf/series")
@AllArgsConstructor
public class SeriesController {
    private final SeriesCommandHandlerImpl commandHandler;
    private final SeriesQueryHandlerImpl queryHandler;

    @GetMapping
    public List<SeriesDetails> getSeries() {
        return queryHandler.findAll();
    }

    @GetMapping("/{id}")
    public SeriesDetails getById(@PathVariable long id) {
        return queryHandler.findById(id);
    }

    @PostMapping
    public void create(final SeriesRegistration seriesRegistration) {
        commandHandler.save(seriesRegistration);
    }

    @PutMapping("/{id}")
    public void update(long id, final SeriesRegistration seriesRegistration) {
        commandHandler.update(id, seriesRegistration);
    }
}
