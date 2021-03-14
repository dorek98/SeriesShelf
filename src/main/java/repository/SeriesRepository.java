package repository;

import model.Platform;
import model.Series;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class SeriesRepository {
    private EntityManager em;

    public SeriesRepository(EntityManager em) {
        this.em = em;
    }

    public void createNewSeries(String title, int numberOfSeasons, Platform platform, int yearOfPremiere) {
        Series series = new Series(title, numberOfSeasons, platform, yearOfPremiere);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(series);
        transaction.commit();
    }

    public Series findById(long id) {
        return em.find(Series.class, id);
    }
}
