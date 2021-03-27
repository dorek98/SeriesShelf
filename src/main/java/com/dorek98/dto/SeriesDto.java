package com.dorek98.dto;

import com.dorek98.model.Platform;
import lombok.Value;

import java.util.List;

@Value
public class SeriesDto {

    long id;
    String title;
    List<RoleDto> roles;
    int numberOfSeasons;
    Platform platform;
    int yearOfPremiere;
}
