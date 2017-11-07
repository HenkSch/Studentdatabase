package de.nordakademie.studentdatabase.advisor.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
@Repository
public class AdvisorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Advisor> findAll() {
        return entityManager.createQuery("SELECT a FROM Advisor a", Advisor.class).getResultList();
    }

    public Advisor findOne(Long advisorId) {
        return entityManager.find(Advisor.class, advisorId);
    }

    public void create(final Advisor advisor) {
        entityManager.persist(advisor);
    }

    public void update(final Advisor advisor) {
        entityManager.merge(advisor);
    }

    public void delete(Advisor advisor) {
        entityManager.remove(advisor);
    }

    public List<Long> getAllUsedContactDataIds() {
        return entityManager.createQuery("select a.contactData.id from Advisor a", Long.class).getResultList();
    }

    public List<Long> getAllIds() {
        return entityManager.createQuery("Select a.id FROM Advisor a", Long.class).getResultList();
    }
}
