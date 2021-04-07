package com.dorek98.service.series;

import com.dorek98.dto.series.SeriesDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SeriesQueryHandler {

    List<SeriesDetails> findAll();

    ResponseEntity<SeriesDetails> findById(long id);
}
