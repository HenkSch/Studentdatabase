package de.nordakademie.studentdatabase.contactPerson.service;

import de.nordakademie.studentdatabase.company.model.CompanyRepository;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.model.ContactDataRepository;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPerson;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U555987 on 006, 06.11.2017.
 */
@Service
public class ContactPersonService {

    private final ContactPersonRepository contactPersonRepository;
    private final ContactDataRepository contactDataRepository;
    private final CompanyRepository companyRepository;
    private Long id;

    @Autowired
    public ContactPersonService(ContactPersonRepository contactPersonRepository, ContactDataRepository contactDataRepository, CompanyRepository companyRepository) {
        this.contactPersonRepository = contactPersonRepository;
        this.contactDataRepository = contactDataRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    public List<ContactPerson> findAll() {
        return contactPersonRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ContactPerson findOne(final Long contactPersonId) {
        return contactPersonRepository.findOne(contactPersonId);
    }

    @Transactional
    public void create(final ContactPerson contactPerson) {
        final ContactData contactData = contactDataRepository.findOne(contactPerson.getContactData().getId());
        contactPerson.setContactData(contactData);

        contactPersonRepository.create(contactPerson);
    }

    @Transactional
    public void update(final ContactPerson contactPerson) {
        contactPersonRepository.update(contactPerson);
    }

    @Transactional
    public void deleteBy(final Long contactPersonId) {
        final ContactPerson contactPerson = contactPersonRepository.findOne(contactPersonId);
        if (contactPerson != null) {
            contactPersonRepository.delete(contactPerson);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getUnusedIds() {

        final List<Long> usedContactPersonIds = new ArrayList<>();
        usedContactPersonIds.addAll(companyRepository.getAllUsedContactPersonIds());

        return contactPersonRepository.getUnusedIds(usedContactPersonIds);
    }
}
