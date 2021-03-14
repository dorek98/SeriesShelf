package repository;

import model.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ActorRepository {
    private EntityManager em;

    public ActorRepository(EntityManager em) {
        this.em = em;
    }

    public void createNewActor(String firstname, String lastname, int age) {
        Actor newActor = new Actor(firstname, lastname, age);
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(newActor);
        transaction.commit();
    }

    public Actor findById(long id) {
        return em.find(Actor.class, id);
    }

    public void updateAge(Actor actor, int newAge) {
        EntityTransaction transaction = em.getTransaction();
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
