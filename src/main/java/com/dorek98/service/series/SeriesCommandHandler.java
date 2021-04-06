package com.dorek98.service.series;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;

import java.util.Optional;


public interface SeriesCommandHandler {

    void save(SeriesRegistration series);

    Optional<SeriesDetails> update(long id, SeriesRegistration series);
}
