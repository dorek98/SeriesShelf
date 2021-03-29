package com.dorek98.service.series;

import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class SeriesCommandHandlerImpl implements SeriesCommandHandler {

    private final SeriesRepository seriesRepository;

    @Override
    public void save(Series series) {
        seriesRepository.save(series);
    }

    @Override
    public void update(long id, Series series) {
        Series oldSeries = seriesRepository.getOne(id);
        oldSeries.setNumberOfSeasons(series.getNumberOfSeasons());
        oldSeries.setPlatform(series.getPlatform());
        oldSeries.setTitle(series.getTitle());
        oldSeries.setYearOfPremiere(series.getYearOfPremiere());
        save(oldSeries);
    }
}
