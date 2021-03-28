package com.dorek98.service;

import com.dorek98.model.Actor;
import com.dorek98.model.Role;
import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeriesService {

    private final SeriesRepository seriesRepository;

    public Series save(Series series){
        return seriesRepository.save(series);
    }

    public List<Series> getAll(){
        return seriesRepository.findAll();
    }

    public String getTitle(long id){
        return seriesRepository.getOne(id).getTitle();
    }

    public Series getSeriesById(long id){return seriesRepository.getOne(id);}
}
