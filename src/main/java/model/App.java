package model;

import repository.ActorRepository;
import repository.RoleRepository;
import repository.SeriesRepository;

import javax.persistence.*;

public class App {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("testhibernate");
    private static EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        ActorRepository actorRepository = new ActorRepository(em);
        SeriesRepository seriesRepository = new SeriesRepository(em);
        RoleRepository roleRepository = new RoleRepository(em);


        em.close();
        factory.close();
    }
}


