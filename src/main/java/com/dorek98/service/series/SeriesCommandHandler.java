package com.dorek98.service.series;

import com.dorek98.dto.SeriesDetails;
import com.dorek98.dto.SeriesRegistration;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface SeriesCommandHandler {

    void save(SeriesRegistration series);

    Optional<SeriesDetails> update(long id, SeriesRegistration series);
}
