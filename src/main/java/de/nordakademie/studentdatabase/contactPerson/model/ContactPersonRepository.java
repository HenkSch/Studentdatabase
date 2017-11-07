package de.nordakademie.studentdatabase.contactPerson.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 006, 06.11.2017.
 */
@Repository
public class ContactPersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ContactPerson> findAll() {
        return entityManager.createQuery("SELECT c FROM ContactPerson c", ContactPerson.class).getResultList();
    }

    public ContactPerson findOne(Long contactPersonId) {
        return entityManager.find(ContactPerson.class, contactPersonId);
    }

    public void create(final ContactPerson contactPerson) {
        entityManager.persist(contactPerson);
    }

    public void update(final ContactPerson contactPerson) {
        entityManager.merge(contactPerson);
    }

    public void delete(ContactPerson contactPerson) {
        entityManager.remove(contactPerson);
    }

    public List<Long> getAllUsedContactDataIds() {
        return entityManager.createQuery("select c.contactData.id from ContactPerson c", Long.class).getResultList();
    }

    public List<Long> getUnusedIds(List<Long> usedIds) {
        return entityManager.createQuery("SELECT c.id FROM ContactPerson c where c.id not in (" + StringUtils.join(usedIds, ',') + ")", Long.class).getResultList();
    }
}
