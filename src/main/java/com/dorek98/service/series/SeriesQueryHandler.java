package com.dorek98.service.series;

import com.dorek98.dto.SeriesDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeriesQueryHandler {

    List<SeriesDetails> findAll();

    SeriesDetails findById(long id);
}
