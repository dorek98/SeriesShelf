package com.dorek98.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seriesId;
    private String title;
    private int numberOfSeasons;
    @Enumerated(EnumType.STRING)
    private Platform platform;
    private int yearOfPremiere;


    @OneToMany(mappedBy = "series")
    private List<Role> roles;


    public Series(String title, int numberOfSeasons, Platform platform, int yearOfPremiere) {
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.platform = platform;
        this.yearOfPremiere = yearOfPremiere;
    }


    @Override
    public String toString() {
        return "Series{" +
                "seriesId=" + seriesId +
                ", title='" + title + '\'' +
                ", numberOfSeasons=" + numberOfSeasons +
                ", platform=" + platform +
                ", yearOfPremiere=" + yearOfPremiere +
                '}';
    }
}
