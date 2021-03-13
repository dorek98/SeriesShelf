package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("testhibernate");
    private static EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        ActorRepository actorRepository = new ActorRepository(em);
        SeriesRepository seriesRepository = new SeriesRepository(em);
        RoleRepository roleRepository = new RoleRepository(em);
        actorRepository.createNewActor("Kit", "Harington", 34);
        seriesRepository.createNewSeries("Game of Thrones", 8, Platform.HBO, 2011);
        roleRepository.createNewRole("Jon Snow", seriesRepository.findById(1), actorRepository.findById(1));
        /*
        Actor actor = actorRepository.findById(1);
        System.out.println(actor.getActor_id());
        actorRepository.updateAge(actor, 35);
        actorRepository.delete(actor);

         */
    }


}


