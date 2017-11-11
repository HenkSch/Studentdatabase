package de.nordakademie.studentdatabase.contactData.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 019, 19.10.2017.
 */
@Repository
public class ContactDataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * finds all contactData
     *
     * @return
     */
    public List<ContactData> findAll() {
        return entityManager.createQuery("SELECT c FROM ContactData c", ContactData.class).getResultList();
    }

    /**
     * returns a contactData by contactDataId
     * @param contactDataId
     * @return
     */
    public ContactData findOne(Long contactDataId) {
        return entityManager.find(ContactData.class, contactDataId);
    }

    /**
     * creates a contactData
     * @param contactData
     */
    public void create(final ContactData contactData) {
        entityManager.persist(contactData);
    }

    /**
     * updates a contactData
     * @param contactData
     */
    public void update(final ContactData contactData) {
        entityManager.merge(contactData);
    }

    /**
     * deletes a contactData
     * @param contactData
     */
    public void delete(ContactData contactData) {
        entityManager.remove(contactData);
    }

    /**
     * returns all contactDataIds which are not in usedIds
     * @param usedIds
     * @return
     */
    public List<Long> getUnusedIds(List<Long> usedIds) {
        return entityManager.createQuery("SELECT c.id FROM ContactData c where c.id not in (" + StringUtils.join(usedIds, ',') + ")", Long.class).getResultList();
    }
}
