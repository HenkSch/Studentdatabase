package de.nordakademie.studentdatabase.company.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann on 023, 23.10.2017.
 */
@Repository
public class CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Company> findAll() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }

    public Company findOne(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }

    public void create(final Company company) {
        entityManager.persist(company);
    }

    public void update(final Company company) {
        entityManager.merge(company);
    }

    public void delete(Company company) {
        entityManager.remove(company);
    }

    public List<Long> getAllIds() {
        return entityManager.createQuery("Select c.id FROM Company c", Long.class).getResultList();
    }

    public List<Long> getAllUsedContactPersonIds() {
        return entityManager.createQuery("select c.contactPerson.id From Company c", Long.class).getResultList();
    }

    public Boolean isAddressUsed(Long addressId) {
        final List<Company> resultList = entityManager.createQuery("select c FROM Company c where c.address.id = " + addressId, Company.class).getResultList();
        return (resultList.size() > 0);
    }

    public boolean isContactPersonUsed(Long contactPersonId) {
        final List<Company> resultList = entityManager.createQuery("select c FROM Company c where c.contactPerson.id = " + contactPersonId, Company.class).getResultList();
        return (resultList.size() > 0);
    }
}
