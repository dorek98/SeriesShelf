package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class App {


    public static void main(String[] args) {
        ActorRepository repo = new ActorRepository();
        repo.createNewActor("John","Wick",30);





        /*
        Actor actor = new Actor();
        actor.setFirstname("John");
        actor.setLastname("Wick");
        actor.setAge(30);
        ActorDao actorDao = new ActorDao();
        Actor actor = new Actor();
        actor.setFirstname("John");
        actor.setLastname("Wick");
        actor.setAge(30);
        actorDao.addActor(actor); */
    }


}


