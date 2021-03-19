package repository;

import model.Actor;
import model.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoleRepository {
    private EntityManager em;

    public RoleRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Role role) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(role);
        transaction.commit();
    }

    public List<Role> getAll() {
        return em.createQuery("select a from Role a", Role.class).getResultList();
    }

    public Role findById(long id) {
        return em.find(Role.class, id);
    }

    public Role getRoleByName(String roleName) {
        TypedQuery<Role> query = em.createQuery(" select a from Role a where roleName like ?1", Role.class);
        return query.setParameter(1, "%" + roleName + "%").getSingleResult();
    }

    public void updateRoleName(long id, String newRoleName) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Role updatingRole = findById(id);
        updatingRole.setRoleName(newRoleName);
        transaction.commit();
    }

    public void delete(Role role) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(role);
        transaction.commit();
    }
}
