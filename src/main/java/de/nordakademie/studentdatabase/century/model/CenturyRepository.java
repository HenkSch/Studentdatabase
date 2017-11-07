package de.nordakademie.studentdatabase.century.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
@Repository
public class CenturyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Century> findAll() {
        return entityManager.createQuery("SELECT c FROM Century c", Century.class).getResultList();
    }

    public Century findOne(Long centuryId) {
        return entityManager.find(Century.class, centuryId);
    }

    public void create(final Century century) {
        entityManager.persist(century);
    }

    public void update(final Century century) {
        entityManager.merge(century);
    }

    public void delete(Century century) {
        entityManager.remove(century);
    }

    public List<Long> getAllIds() {
        return entityManager.createQuery("Select c.id FROM Century c", Long.class).getResultList();
    }
}
