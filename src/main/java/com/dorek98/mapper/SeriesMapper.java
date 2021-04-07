package com.dorek98.mapper;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import com.dorek98.model.Series;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeriesMapper {

    Series toSeries(final SeriesRegistration series);

    @Mapping(target = "id", source = "series_id")
    SeriesDetails toSeriesDetails(final Series series);

    List<SeriesDetails> toSeriesDetailsList(final List<Series> seriesList);
}
