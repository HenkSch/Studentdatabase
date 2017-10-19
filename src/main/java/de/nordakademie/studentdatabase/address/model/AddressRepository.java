package de.nordakademie.studentdatabase.address.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Address findOne(Long id) {
        return entityManager.find(Address.class, id);
    }
}
