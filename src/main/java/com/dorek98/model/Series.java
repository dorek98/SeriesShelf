package com.dorek98.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long series_id;
    private String title;
    private int numberOfSeasons;
    @Enumerated(EnumType.STRING)
    private Platform platform;
    private int yearOfPremiere;


    @OneToMany(mappedBy = "series")
    private List<Role> roles;


    public Series() {
    }

    public Series(String title, int numberOfSeasons, Platform platform, int yearOfPremiere) {
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.platform = platform;
        this.yearOfPremiere = yearOfPremiere;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }


    public void setPlatform(Platform platform) {
        this.platform = platform;
    }


    public void setYearOfPremiere(int yearOfPremiere) {
        this.yearOfPremiere = yearOfPremiere;
    }

    @Override
    public String toString() {
        return "Series{" +
                "series_id=" + series_id +
                ", title='" + title + '\'' +
                ", numberOfSeasons=" + numberOfSeasons +
                ", platform=" + platform +
                ", yearOfPremiere=" + yearOfPremiere +
                '}';
    }
}
