package com.dorek98.mapper;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import com.dorek98.model.Series;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface SeriesMapper {

    Series toSeries(final SeriesRegistration series);

    @Mapping(target = "id", source = "seriesId")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "numberOfSeasons", source = "numberOfSeasons")
    @Mapping(target = "platform", source = "platform")
    @Mapping(target = "yearOfPremiere", source = "yearOfPremiere")
    @Mapping(target = "roles", source = "roles")
    SeriesDetails toSeriesDetails(final Series series);

    List<SeriesDetails> toSeriesDetailsList(final List<Series> seriesList);
}
