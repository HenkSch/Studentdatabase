package de.nordakademie.studentdatabase.advisor.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 023, 23.10.2017.
 */
@Repository
public class AdvisorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * finds all advisors
     *
     * @return
     */
    public List<Advisor> findAll() {
        return entityManager.createQuery("SELECT a FROM Advisor a", Advisor.class).getResultList();
    }

    /**
     * returns an advisor with advisorId
     * @param advisorId
     * @return
     */
    public Advisor findOne(Long advisorId) {
        return entityManager.find(Advisor.class, advisorId);
    }

    /**
     * creates an advisor
     * @param advisor
     */
    public void create(final Advisor advisor) {
        entityManager.persist(advisor);
    }

    /**
     * updates an advisor
     * @param advisor
     */
    public void update(final Advisor advisor) {
        entityManager.merge(advisor);
    }

    /**
     * deletes an advisor
     * @param advisor
     */
    public void delete(Advisor advisor) {
        entityManager.remove(advisor);
    }

    /**
     * returns all used contactDataIds in advisor
     * @return
     */
    public List<Long> getAllUsedContactDataIds() {
        return entityManager.createQuery("select a.contactData.id from Advisor a", Long.class).getResultList();
    }

    /**
     * returns all advisorIds
     * @return
     */
    public List<Long> getAllIds() {
        return entityManager.createQuery("Select a.id FROM Advisor a", Long.class).getResultList();
    }

    /**
     * checks if contactData with contactDataId is used in advisor
     * @param contactDataId
     * @return
     */
    public Boolean isContactDataUsed(Long contactDataId) {
        final List<Advisor> resultList = entityManager.createQuery("select a FROM Advisor a where a.contactData.id = " + contactDataId, Advisor.class).getResultList();
        return (resultList.size() > 0);
    }
}
