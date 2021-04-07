package com.dorek98.service.actor;

import com.dorek98.dto.actor.ActorDetails;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.model.Actor;
import com.dorek98.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class ActorQueryHandlerImpl implements ActorQueryHandler {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    private final EntityManager em;

    @Override
    public List<ActorDetails> findAll() {
        List<Actor> actorList = actorRepository.findAll();
        return actorMapper.toActorDetailsList(actorList);
    }

    @Override
    public ResponseEntity<ActorDetails> findById(long id) {
        try {
            Actor actor = actorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            ActorDetails actorDetails = actorMapper.toActorDetails(actor);
            return ResponseEntity.ok(actorDetails);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<ActorDetails> findAdults() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> actor = cq.from(Actor.class);
        Predicate agePredicate = cb.greaterThanOrEqualTo(actor.get("age"), 18);
        cq.where(agePredicate);
        TypedQuery<Actor> query = em.createQuery(cq);
        return actorMapper.toActorDetailsList(query.getResultList());
    }
}
