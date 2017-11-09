package de.nordakademie.studentdatabase.company.service;

import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.address.model.AddressRepository;
import de.nordakademie.studentdatabase.company.model.Company;
import de.nordakademie.studentdatabase.company.model.CompanyRepository;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPerson;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPersonRepository;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final ContactPersonRepository contactPersonRepository;
    private final StudentInfoRepository studentInfoRepository;
    private Long id;


    @Autowired
    public CompanyService(CompanyRepository companyRepository, AddressRepository addressRepository, ContactPersonRepository contactPersonRepository, StudentInfoRepository studentInfoRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
        this.contactPersonRepository = contactPersonRepository;
        this.studentInfoRepository = studentInfoRepository;
    }

    @Transactional
    public List<Long> getAllIds() {
        return companyRepository.getAllIds();
    }

    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Company findOne(final Long companyId) {
        return companyRepository.findOne(companyId);
    }

    @Transactional
    public void create(final Company company) {
        Address address = addressRepository.findOne(company.getAddress().getId());
        company.setAddress(address);

        ContactPerson contactPerson = contactPersonRepository.findOne(company.getContactPerson().getId());
        company.setContactPerson(contactPerson);

        companyRepository.create(company);
    }

    @Transactional
    public void update(final Company company) {
        companyRepository.update(company);
    }

    @Transactional
    public void deleteBy(final Long companyId) {
        final Company company = companyRepository.findOne(companyId);
        if (company != null) {
            companyRepository.delete(company);
        }
    }

    @Transactional
    public boolean isUsed(Long companyId) {
        return studentInfoRepository.isCompanyUsed(companyId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
