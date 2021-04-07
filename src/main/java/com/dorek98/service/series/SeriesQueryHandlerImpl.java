package com.dorek98.service.series;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.mapper.SeriesMapper;
import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class SeriesQueryHandlerImpl implements SeriesQueryHandler {

    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    @Override
    public List<SeriesDetails> findAll() {
        List<Series> seriesList = seriesRepository.findAll();
        return seriesMapper.toSeriesDetailsList(seriesList);
    }

    @Override
    public ResponseEntity<SeriesDetails> findById(long id) {
        try {
            Series series = seriesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            SeriesDetails seriesDetails = seriesMapper.toSeriesDetails(series);
            return ResponseEntity.ok(seriesDetails);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
