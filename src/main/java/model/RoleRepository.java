package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RoleRepository {
    private EntityManager em;

    public RoleRepository(EntityManager em) {
        this.em = em;
    }

    public void createNewRole(String roleName, Series series, Actor actor) {
        Role role = new Role(roleName, series, actor);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(role);
        transaction.commit();
    }
}
