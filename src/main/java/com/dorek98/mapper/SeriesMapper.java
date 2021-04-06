package com.dorek98.mapper;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import com.dorek98.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeriesMapper {

    @Autowired
    private RoleMapper roleMapper;

    public SeriesDetails toSeriesDetails(Series series) {
        return new SeriesDetails(series.getSeries_id(), series.getTitle(), series.getNumberOfSeasons(), series.getPlatform(), series.getYearOfPremiere(), roleMapper.toDetailsList(series.getRoles()));
    }

    public Series toSeries(SeriesRegistration request) {
        return new Series(request.getTitle(), request.getNumberOfSeasons(), request.getPlatform(), request.getYearOfPremiere());
    }

    public List<SeriesDetails> toDetailsList(List<Series> series) {
        List<SeriesDetails> seriesDtos = new ArrayList<>();
        for (Series s : series) {
            seriesDtos.add(toSeriesDetails(s));
        }
        return seriesDtos;
    }
}
