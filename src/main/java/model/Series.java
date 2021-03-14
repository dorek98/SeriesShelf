package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long series_id;
    private  String title;
    @OneToMany(mappedBy = "series")
    private Set<Role> roles;
    private  int numberOfSeasons;
    @Enumerated(EnumType.STRING)
    private  Platform platform;
    private  int yearOfPremiere;

    public Series() {
    }
    public Series(String title, int numberOfSeasons, Platform platform, int yearOfPremiere) {
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.platform = platform;
        this.yearOfPremiere = yearOfPremiere;
    }

    public Series(long series_id, String title, int numberOfSeasons, Platform platform, int yearOfPremiere) {
        this.series_id = series_id;
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.platform = platform;
        this.yearOfPremiere = yearOfPremiere;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public Platform getPlatform() {
        return platform;
    }

    public int getYearOfPremiere() {
        return yearOfPremiere;
    }

    public long getSeries_id() {
        return series_id;
    }

    public void setSeries_id(long series_id) {
        this.series_id = series_id;
    }

    public void setTitle(String title) {
        this.title = title;
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

    /*
    public void addRole(String role, Actor actor) {
        if (mainRoles.containsKey(role)) {
            System.out.println("Character already exist! Adding failed.");
        } else {
            mainRoles.put(role, actor);
        }
    }
*/

}
