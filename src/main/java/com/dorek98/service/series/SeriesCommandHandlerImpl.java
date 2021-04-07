package com.dorek98.service.series;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import com.dorek98.mapper.SeriesMapper;
import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
@Transactional
public class SeriesCommandHandlerImpl implements SeriesCommandHandler {

    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    @Override
    public void save(SeriesRegistration seriesDTO) {
        Series series = seriesMapper.toSeries(seriesDTO);
        seriesRepository.save(series);
    }

    @Override
    public ResponseEntity<SeriesDetails> update(long id, SeriesRegistration series) {
        try {
            Series oldSeries = seriesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            oldSeries.setNumberOfSeasons(series.getNumberOfSeasons());
            oldSeries.setPlatform(series.getPlatform());
            oldSeries.setTitle(series.getTitle());
            oldSeries.setYearOfPremiere(series.getYearOfPremiere());
            Series newSeries = seriesRepository.save(oldSeries);
            SeriesDetails seriesDetails = seriesMapper.toSeriesDetails(newSeries);
            return ResponseEntity.ok(seriesDetails);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
