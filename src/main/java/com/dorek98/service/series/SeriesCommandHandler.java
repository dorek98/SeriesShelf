package com.dorek98.service.series;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import org.springframework.http.ResponseEntity;


public interface SeriesCommandHandler {

    void save(SeriesRegistration series);

    ResponseEntity<SeriesDetails> update(long id, SeriesRegistration series);
}
