package model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private final String title;
    private final ArrayList<Series> seriesList;

    public Shelf(String title) {
        this.title = title;
        this.seriesList = new ArrayList<>();
    }

    public Shelf(String title, ArrayList<Series> seriesList) {
        this.title = title;
        this.seriesList = seriesList;
    }

    public void addSeries(Series series) {
        boolean check = true;
        for (Series s : seriesList) {
            if (s.getTitle().equals(series.getTitle())) {
                System.out.println("Series already exist in the shelf! Adding failed.");
                check = false;
            }
        }
        if (check) {
            seriesList.add(series);
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Series> getSeriesList() {
        return seriesList;
    }
}
