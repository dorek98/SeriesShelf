package com.dorek98.repository;

import com.dorek98.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@AllArgsConstructor
@Repository
public class ActorRepositoryImpl implements ActorRepositoryCustom {

    EntityManager em;

    @Override
    public List<Actor> findAdultActors() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);

        Root<Actor> actor = cq.from(Actor.class);
        Predicate agePredicate = cb.greaterThanOrEqualTo(actor.get("age"), 18);
        cq.where(agePredicate);
        TypedQuery<Actor> query = em.createQuery(cq);
        return query.getResultList();
    }
}
