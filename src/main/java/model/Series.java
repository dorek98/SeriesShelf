package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long series_id;
    private String title;

    @OneToMany(mappedBy = "series")
    private List<Role> roles = new ArrayList<>();

    private int numberOfSeasons;
    @Enumerated(EnumType.STRING)
    private Platform platform;
    private int yearOfPremiere;

    public Series() {
    }

    public Series(String title, int numberOfSeasons, Platform platform, int yearOfPremiere) {
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.platform = platform;
        this.yearOfPremiere = yearOfPremiere;
    }

    public long getSeries_id() {
        return series_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getYearOfPremiere() {
        return yearOfPremiere;
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
