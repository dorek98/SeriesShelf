package com.dorek98.mapper;

import com.dorek98.dto.RoleDto;
import com.dorek98.dto.SeriesDto;
import com.dorek98.dto.SeriesRequest;
import com.dorek98.model.Platform;
import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeriesMapper {

    @Autowired
    private RoleMapper roleMapper;

    public Series createSeries(SeriesDto seriesDto){
        return new Series(seriesDto.getTitle(),seriesDto.getNumberOfSeasons(),seriesDto.getPlatform(),seriesDto.getYearOfPremiere());
    }

    public SeriesDto createSeriesDto(Series series){
        return new SeriesDto(series.getSeries_id(),series.getTitle(),series.getNumberOfSeasons(),series.getPlatform(),series.getYearOfPremiere(),roleMapper.listToDto(series.getRoles()));
    }

    public Series seriesRequest(SeriesRequest request){
        return new Series(request.getTitle(),request.getNumberOfSeasons(),request.getPlatform(), request.getYearOfPremiere());
    }

    public List<SeriesDto> listToDto(List<Series> series){
        List<SeriesDto> seriesDtos = new ArrayList<>();
        for(Series s : series){
            seriesDtos.add(createSeriesDto(s));
        }
        return seriesDtos;
    }
}
