import model.Actor;
import org.junit.jupiter.api.Test;
import repository.ActorRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest {
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("testhibernate");
    private final EntityManager em = factory.createEntityManager();

    @Test
    public void should_be_able_to_find_actor_by_id() {
        //given: we have added actor to DB
        ActorRepository actorRepository = new ActorRepository(em);
        Actor newActor = new Actor("Test4", "Test4", 3);
        actorRepository.save(newActor);

        //when: we try to get actor by id from DB
        Actor actor = actorRepository.findById(newActor.getActor_id());

        //then: we should get same actor
        assertEquals(newActor, actor);
        em.close();
        factory.close();
    }


}
