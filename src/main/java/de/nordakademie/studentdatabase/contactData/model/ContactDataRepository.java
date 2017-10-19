package de.nordakademie.studentdatabase.contactData.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Repository
public class ContactDataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ContactData findOne(Long id) {
        return entityManager.find(ContactData.class, id);
    }
}
