package com.dorek98.dto.series;

import com.dorek98.model.Platform;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Value
public class SeriesRegistration {
    @NotBlank
    String title;
    @NotNull
    @Positive
    int numberOfSeasons;
    @NotNull
    Platform platform;
    @NotNull
    @Positive
    int yearOfPremiere;
}
