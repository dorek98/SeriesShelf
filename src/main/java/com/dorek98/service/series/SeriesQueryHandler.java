package com.dorek98.service.series;

import com.dorek98.dto.series.SeriesDetails;

import java.util.List;
import java.util.Optional;

public interface SeriesQueryHandler {

    List<SeriesDetails> findAll();

    Optional<SeriesDetails> findById(long id);
}
