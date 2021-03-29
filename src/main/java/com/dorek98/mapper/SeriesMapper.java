package com.dorek98.mapper;

import com.dorek98.dto.SeriesDetails;
import com.dorek98.dto.SeriesRegistration;
import com.dorek98.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeriesMapper {

    @Autowired
    private RoleMapper roleMapper;

    public SeriesDetails createSeriesDto(Series series) {
        return new SeriesDetails(series.getSeries_id(), series.getTitle(), series.getNumberOfSeasons(), series.getPlatform(), series.getYearOfPremiere(), roleMapper.listToDto(series.getRoles()));
    }

    public Series createSeries(SeriesRegistration request) {
        return new Series(request.getTitle(), request.getNumberOfSeasons(), request.getPlatform(), request.getYearOfPremiere());
    }

    public List<SeriesDetails> listToDto(List<Series> series) {
        List<SeriesDetails> seriesDtos = new ArrayList<>();
        for (Series s : series) {
            seriesDtos.add(createSeriesDto(s));
        }
        return seriesDtos;
    }
}
