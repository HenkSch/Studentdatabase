package de.nordakademie.studentdatabase.company.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
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
}
