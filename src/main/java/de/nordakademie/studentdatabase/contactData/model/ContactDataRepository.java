package de.nordakademie.studentdatabase.contactData.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Repository
public class ContactDataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ContactData> findAll() {
        return entityManager.createQuery("SELECT c FROM ContactData c", ContactData.class).getResultList();
    }

    public ContactData findOne(Long contactDataId) {
        return entityManager.find(ContactData.class, contactDataId);
    }

    public void create(final ContactData contactData) {
        entityManager.persist(contactData);
    }

    public void update(final ContactData contactData) {
        entityManager.merge(contactData);
    }

    public void delete(ContactData contactData) {
        entityManager.remove(contactData);
    }

    public List<Long> getUnusedIds(List<Long> usedIds) {
        return entityManager.createQuery("SELECT c.id FROM ContactData c where c.id not in (" + StringUtils.join(usedIds, ',') + ")", Long.class).getResultList();
    }
}
