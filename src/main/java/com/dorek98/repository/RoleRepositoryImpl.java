package com.dorek98.repository;

import com.dorek98.model.Role;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
@Repository
public class RoleRepositoryImpl implements RoleRepositoryCustom {

    EntityManager em;

    @Override
    public Role findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);

        Root<Role> role = cq.from(Role.class);
        Predicate predicate = cb.like(role.get("roleName"),"%"+name+"%");
        cq.where(predicate);
        TypedQuery<Role> query = em.createQuery(cq);
        return query.getResultList().get(0);
    }
}
