package de.nordakademie.studentdatabase.century.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 023, 23.10.2017.
 */
@Repository
public class CenturyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * finds all centuries
     *
     * @return
     */
    public List<Century> findAll() {
        return entityManager.createQuery("SELECT c FROM Century c", Century.class).getResultList();
    }

    /**
     * returns a century by centuryId
     * @param centuryId
     * @return
     */
    public Century findOne(Long centuryId) {
        return entityManager.find(Century.class, centuryId);
    }

    /**
     * creates a century
     * @param century
     */
    public void create(final Century century) {
        entityManager.persist(century);
    }

    /**
     * updates a century
     * @param century
     */
    public void update(final Century century) {
        entityManager.merge(century);
    }

    /**
     * deletes a century
     * @param century
     */
    public void delete(Century century) {
        entityManager.remove(century);
    }

    /**
     * returns all centuryIds
     * @return
     */
    public List<Long> getAllIds() {
        return entityManager.createQuery("Select c.id FROM Century c", Long.class).getResultList();
    }
}
