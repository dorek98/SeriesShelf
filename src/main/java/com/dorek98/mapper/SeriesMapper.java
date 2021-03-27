package com.dorek98.mapper;

import com.dorek98.dto.RoleDto;
import com.dorek98.dto.SeriesDto;
import com.dorek98.model.Platform;
import com.dorek98.model.Series;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeriesMapper {

    public Series createSeries(SeriesDto seriesDto){
        return new Series(seriesDto.getTitle(),seriesDto.getNumberOfSeasons(),seriesDto.getPlatform(),seriesDto.getYearOfPremiere());
    }

    public SeriesDto createSeriesDto(Series series){
        return new SeriesDto(series.getSeries_id(),series.getTitle(),series.getRoles(),series.getNumberOfSeasons(),series.getPlatform(),series.getYearOfPremiere());
    }

    public List<SeriesDto> listToDto(List<Series> series){
        List<SeriesDto> seriesDtos = new ArrayList<>();
        for(Series s : series){
            seriesDtos.add(createSeriesDto(s));
        }
    }
}
