package de.nordakademie.studentdatabase.contactPerson.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 006, 06.11.2017.
 */
@Repository
public class ContactPersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * finds all contactPersons
     *
     * @return
     */
    public List<ContactPerson> findAll() {
        return entityManager.createQuery("SELECT c FROM ContactPerson c", ContactPerson.class).getResultList();
    }

    /**
     * returns a contactPerson by contactPersonId
     * @param contactPersonId
     * @return
     */
    public ContactPerson findOne(Long contactPersonId) {
        return entityManager.find(ContactPerson.class, contactPersonId);
    }

    /**
     * creates a contactPerson
     * @param contactPerson
     */
    public void create(final ContactPerson contactPerson) {
        entityManager.persist(contactPerson);
    }

    /**
     * updates a contactPerson
     * @param contactPerson
     */
    public void update(final ContactPerson contactPerson) {
        entityManager.merge(contactPerson);
    }

    /**
     * deletes a contactPerson
     * @param contactPerson
     */
    public void delete(ContactPerson contactPerson) {
        entityManager.remove(contactPerson);
    }

    /**
     * returns all used contactDataIds from contactPerson
     * @return
     */
    public List<Long> getAllUsedContactDataIds() {
        return entityManager.createQuery("select c.contactData.id from ContactPerson c", Long.class).getResultList();
    }

    /**
     * returns all contactPersonIds which are not in usedIds
     * @param usedIds
     * @return
     */
    public List<Long> getUnusedIds(List<Long> usedIds) {
        return entityManager.createQuery("SELECT c.id FROM ContactPerson c where c.id not in (" + StringUtils.join(usedIds, ',') + ")", Long.class).getResultList();
    }

    /**
     * checks if contactData with contactDataId is used in contactPerson
     * @param contactDataId
     * @return
     */
    public Boolean isContactDataUsed(Long contactDataId) {
        final List<ContactPerson> resultList = entityManager.createQuery("select c FROM ContactPerson c where c.contactData.id = " + contactDataId, ContactPerson.class).getResultList();
        return (resultList.size() > 0);
    }
}
