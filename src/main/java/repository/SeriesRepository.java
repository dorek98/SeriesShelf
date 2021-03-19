package repository;

import model.Series;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class SeriesRepository {
    private EntityManager em;

    public SeriesRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Series series) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(series);
        transaction.commit();
    }

    public Series findById(long id) {
        return em.find(Series.class, id);
    }

    public List<Series> getAll() {
        return em.createQuery("select a from Series a ", Series.class).getResultList();
    }

    public Series getSeriesByTitle(String title) {
        TypedQuery<Series> query = em.createQuery(" select a from Series a where title like ?1", Series.class);
        return query.setParameter(1, "%" + title + "%").getSingleResult();
    }

    public void updateSeries(long id, Series series) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Series updatedSeries = findById(id);
        updatedSeries.setTitle(series.getTitle());
        updatedSeries.setNumberOfSeasons(series.getNumberOfSeasons());
        updatedSeries.setPlatform(series.getPlatform());
        updatedSeries.setYearOfPremiere(series.getYearOfPremiere());
        transaction.commit();
    }

    public void delete(Series series) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(series);
        transaction.commit();
    }


}
