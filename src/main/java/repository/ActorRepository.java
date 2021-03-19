package repository;

import model.Actor;

import javax.persistence.*;
import java.util.List;

public class ActorRepository {
    private EntityManager em;

    public ActorRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Actor actor) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(actor);
        transaction.commit();
    }

    public Actor findById(long id) {
        return em.find(Actor.class, id);
    }

    public List<Actor> getAll() {
        return em.createQuery("select a from Actor a", Actor.class).getResultList();
    }

    public Actor getActorByName(String firstname) {
        TypedQuery<Actor> query = em.createQuery(" select a from Actor a where first_name like ?1", Actor.class);
        return query.setParameter(1, "%" + firstname + "%").getSingleResult();
    }

    public void updateActor(long id, Actor actor) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Actor updatedActor = findById(id);
        updatedActor.setFirstName(actor.getFirstName());
        updatedActor.setLastName(actor.getLastName());
        updatedActor.setAge(actor.getAge());
        transaction.commit();
    }

    public void delete(Actor actor) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(actor);
        transaction.commit();
    }
}
