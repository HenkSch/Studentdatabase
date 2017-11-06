package de.nordakademie.studentdatabase.contactPerson.model;

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

    public List<Long> getAllUsedIds() {
        return entityManager.createQuery("select c.contactData.id from ContactPerson c", Long.class).getResultList();
    }
}
