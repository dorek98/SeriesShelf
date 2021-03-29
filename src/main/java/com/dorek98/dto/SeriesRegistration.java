package com.dorek98.dto;

import com.dorek98.model.Platform;
import lombok.Value;


@Value
public class SeriesRegistration {
    String title;
    int numberOfSeasons;
    Platform platform;
    int yearOfPremiere;
}
