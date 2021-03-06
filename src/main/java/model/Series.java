package model;

import java.util.HashMap;
import java.util.Map;

public class Series {
    private final String title;
    private final int numberOfSeasons;
    private final Platform platform;
    private final int yearOfPremiere;
    private final Map<String, Actor> mainRoles = new HashMap<>();

    public Series(String title, int numberOfSeasons, Platform platform, int yearOfPremiere) {
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.platform = platform;
        this.yearOfPremiere = yearOfPremiere;
    }

    public void addRole(String role, Actor actor) {
        if (mainRoles.containsKey(role)) {
            System.out.println("Character already exist! Adding failed.");
        } else {
            mainRoles.put(role, actor);
        }
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

    public Map<String, Actor> getMainRoles() {
        return mainRoles;
    }
}
