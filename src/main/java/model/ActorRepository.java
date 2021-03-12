package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ActorRepository {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("testhibernate");
    private static EntityManager em = factory.createEntityManager();

    public void createNewActor(String firstname, String lastname, int age) {
        System.out.println("============CREATE================");
        Actor newActor = new Actor(firstname, lastname, age);
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        System.out.println("----------New transaction-----------");

        em.persist(newActor);
        System.out.println("New Actor ID " + newActor.getActor_id());

        System.out.println("----------CLOSING-----------");
        transaction.commit();

    }

    public Actor findById(long id) {
        System.out.println("===========FIND BY ID =========");
        return em.find(Actor.class, id);
    }

    public void updateAge(Actor actor, int newAge) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("===========UPDATE =========");
        transaction.begin();
        actor.setAge(newAge);
        transaction.commit();
    }

    public void delete(Actor actor) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("===========DELETE =========");
        transaction.begin();
        em.remove(actor);
        transaction.commit();
    }
}
