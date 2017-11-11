package de.nordakademie.studentdatabase.company.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 023, 23.10.2017.
 */
@Repository
public class CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * finds all companies
     *
     * @return
     */
    public List<Company> findAll() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }

    /**
     * finds a company by companyId
     * @param companyId
     * @return
     */
    public Company findOne(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }

    /**
     * creates a company
     * @param company
     */
    public void create(final Company company) {
        entityManager.persist(company);
    }

    /**
     * updates a company
     * @param company
     */
    public void update(final Company company) {
        entityManager.merge(company);
    }

    /**
     * deletes a company
     * @param company
     */
    public void delete(Company company) {
        entityManager.remove(company);
    }

    /**
     * returns all companyIds
     * @return
     */
    public List<Long> getAllIds() {
        return entityManager.createQuery("Select c.id FROM Company c", Long.class).getResultList();
    }

    /**
     * returns all used contactPersonIds in company
     * @return
     */
    public List<Long> getAllUsedContactPersonIds() {
        return entityManager.createQuery("select c.contactPerson.id From Company c", Long.class).getResultList();
    }

    /**
     * checks if address with addressId is used in company
     * @param addressId
     * @return
     */
    public Boolean isAddressUsed(Long addressId) {
        final List<Company> resultList = entityManager.createQuery("select c FROM Company c where c.address.id = " + addressId, Company.class).getResultList();
        return (resultList.size() > 0);
    }

    /**
     * checks if contactPerson with contactPersonId is used in company
     * @param contactPersonId
     * @return
     */
    public boolean isContactPersonUsed(Long contactPersonId) {
        final List<Company> resultList = entityManager.createQuery("select c FROM Company c where c.contactPerson.id = " + contactPersonId, Company.class).getResultList();
        return (resultList.size() > 0);
    }
}
