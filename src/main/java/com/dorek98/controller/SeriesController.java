package com.dorek98.controller;

import com.dorek98.dto.SeriesDto;
import com.dorek98.dto.SeriesRequest;
import com.dorek98.mapper.SeriesMapper;
import com.dorek98.model.Series;
import com.dorek98.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seriesshelf/series")
@AllArgsConstructor
public class SeriesController {
    private final SeriesMapper seriesMapper;
    private final SeriesService seriesService;

    @GetMapping
    public List<SeriesDto> getSeries() {
        return seriesMapper.listToDto(seriesService.getAll());
    }

    @GetMapping("/{id}")
    public SeriesDto getById(@PathVariable long id) {
        return seriesMapper.createSeriesDto(seriesService.getSeriesById(id));
    }

    @PostMapping
    public Series create(final SeriesRequest request) {
        return seriesService.save(seriesMapper.createSeries(request));
    }
}
