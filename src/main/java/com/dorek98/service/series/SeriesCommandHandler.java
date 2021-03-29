package com.dorek98.service.series;

import com.dorek98.dto.SeriesRegistration;
import org.springframework.stereotype.Service;


@Service
public interface SeriesCommandHandler {

    void save(SeriesRegistration series);

    void update(long id, SeriesRegistration series);
}
