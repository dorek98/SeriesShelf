package com.dorek98.service.series;

import com.dorek98.model.Series;
import org.springframework.stereotype.Service;


@Service
public interface SeriesCommandHandler {

    void save(Series series);

    void update(long id, Series series);
}
