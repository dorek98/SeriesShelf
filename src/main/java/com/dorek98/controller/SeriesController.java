package com.dorek98.controller;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import com.dorek98.service.series.SeriesCommandHandlerImpl;
import com.dorek98.service.series.SeriesQueryHandlerImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/series-shelf/series")
@AllArgsConstructor
public class SeriesController {
    private final SeriesCommandHandlerImpl commandHandler;
    private final SeriesQueryHandlerImpl queryHandler;

    @GetMapping
    public List<SeriesDetails> getSeries() {
        return queryHandler.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeriesDetails> getById(@PathVariable("id") long id) {
        return queryHandler.findById(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(final @Valid SeriesRegistration seriesRegistration) {
        commandHandler.save(seriesRegistration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeriesDetails> update(@PathVariable("id") long id, final @Valid SeriesRegistration seriesRegistration) {
        return commandHandler.update(id, seriesRegistration);
    }
}
