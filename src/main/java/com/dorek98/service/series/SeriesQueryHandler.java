package com.dorek98.service.series;

import com.dorek98.dto.SeriesDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SeriesQueryHandler {

    List<SeriesDetails> findAll();

    Optional<SeriesDetails> findById(long id);
}
