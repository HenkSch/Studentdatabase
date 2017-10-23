package de.nordakademie.studentdatabase.address.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }

    public Address findOne(Long addressId) {
        return entityManager.find(Address.class, addressId);
    }

    public void create(final Address address) {
        entityManager.persist(address);
    }

    public void update(final Address address) {
        entityManager.merge(address);
    }

    public void delete(Address address) {
        entityManager.remove(address);
    }
}
