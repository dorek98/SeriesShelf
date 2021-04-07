package com.dorek98.service.series;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import com.dorek98.mapper.SeriesMapper;
import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class SeriesCommandHandlerImpl implements SeriesCommandHandler {

    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    @Override
    public void save(SeriesRegistration series) {
        seriesRepository.save(seriesMapper.toSeries(series));
    }

    @Override
    public Optional<SeriesDetails> update(long id, SeriesRegistration series) {
        try {
            Series oldSeries = seriesRepository.getOne(id);
            oldSeries.setNumberOfSeasons(series.getNumberOfSeasons());
            oldSeries.setPlatform(series.getPlatform());
            oldSeries.setTitle(series.getTitle());
            oldSeries.setYearOfPremiere(series.getYearOfPremiere());
            return Optional.of(seriesMapper.toSeriesDetails(seriesRepository.save(oldSeries)));
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }
}
