package com.dorek98.service.series;

import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class SeriesQueryHandlerImpl implements SeriesQueryHandler {

    private final SeriesRepository seriesRepository;

    @Override
    public List<Series> findAll() {
        return seriesRepository.findAll();
    }

    @Override
    public Series findById(long id) {
        return seriesRepository.getOne(id);
    }
}
