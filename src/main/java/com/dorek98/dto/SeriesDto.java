package com.dorek98.dto;

import com.dorek98.model.Platform;
import lombok.Value;

import java.util.List;

@Value
public class SeriesDto {

    long id;
    String title;
    int numberOfSeasons;
    Platform platform;
    int yearOfPremiere;
    List<RoleDto> roles;
}
