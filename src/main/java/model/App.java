package model;

import repository.ActorRepository;
import repository.RoleRepository;
import repository.SeriesRepository;

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
//        actorRepository.createNewActor("Kit", "Harington", 34);
//        seriesRepository.createNewSeries("Game of Thrones", 8, Platform.HBO, 2011);
//        roleRepository.createNewRole("Jon Snow", seriesRepository.findById(1), actorRepository.findById(1));
//
//        actorRepository.createNewActor("Sean", "Bean", 61);
//        roleRepository.createNewRole("Eddard Stark", seriesRepository.findById(1), actorRepository.findById(2));
//
//        seriesRepository.createNewSeries("Snowpiercer", 2, Platform.Netflix, 2020);
//        roleRepository.createNewRole("Wilford", seriesRepository.findById(2), actorRepository.findById(2));

        actorRepository.updateAge(actorRepository.findById(1), 36);


    }


}


