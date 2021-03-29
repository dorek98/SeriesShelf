package com.dorek98.service.series;

import com.dorek98.model.Series;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeriesQueryHandler {

    List<Series> findAll();

    Series findById(long id);

    //TODO: Actor findByName(String firstName);
}
