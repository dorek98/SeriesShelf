package com.dorek98.service;

import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeriesService {

    private final SeriesRepository seriesRepository;

}
