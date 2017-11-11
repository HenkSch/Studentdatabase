package de.nordakademie.studentdatabase.address.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 019, 19.10.2017.
 */
@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * returns all addresses
     *
     * @return
     */
    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }

    /**
     * finds one address by addressId
     * @param addressId
     * @return
     */
    public Address findOne(Long addressId) {
        return entityManager.find(Address.class, addressId);
    }

    /**
     * creates an address
     * @param address
     */
    public void create(final Address address) {
        entityManager.persist(address);
    }

    /**
     * updates an address
     * @param address
     */
    public void update(final Address address) {
        entityManager.merge(address);
    }

    /**
     * deletes an address
     * @param address
     */
    public void delete(Address address) {
        entityManager.remove(address);
    }

    /**
     * returns all addressIds
     * @return
     */
    public List<Long> getAllIds() {
        return entityManager.createQuery("Select a.id FROM Address a", Long.class).getResultList();
    }
}
