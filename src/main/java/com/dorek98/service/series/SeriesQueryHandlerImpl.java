package com.dorek98.service.series;

import com.dorek98.dto.SeriesDetails;
import com.dorek98.mapper.SeriesMapper;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class SeriesQueryHandlerImpl implements SeriesQueryHandler {

    private final SeriesMapper seriesMapper;
    private final SeriesRepository seriesRepository;

    @Override
    public List<SeriesDetails> findAll() {
        return seriesMapper.listToDetails(seriesRepository.findAll());
    }

    @Override
    public SeriesDetails findById(long id) {
        try {
            return seriesMapper.createSeriesDetails(seriesRepository.getOne(id));
        } catch (EntityNotFoundException ex) {
            return null;
        }
    }
}
