package de.nordakademie.studentdatabase.contactData.service;

import de.nordakademie.studentdatabase.advisor.model.AdvisorRepository;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.model.ContactDataRepository;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPersonRepository;
import de.nordakademie.studentdatabase.student.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U555987 on 020, 20.10.2017.
 */
@Service
public class ContactDataService {

    private final ContactDataRepository contactDataRepository;
    private final StudentRepository studentRepository;
    private final ContactPersonRepository contactPersonRepository;
    private final AdvisorRepository advisorRepository;
    private Long id;

    @Autowired
    public ContactDataService(ContactDataRepository contactDataRepository, StudentRepository studentRepository, ContactPersonRepository contactPersonRepository, AdvisorRepository advisorRepository) {
        this.contactDataRepository = contactDataRepository;
        this.studentRepository = studentRepository;
        this.contactPersonRepository = contactPersonRepository;
        this.advisorRepository = advisorRepository;
    }

    @Transactional
    public List<Long> getUnusedIds() {
        final List<Long> usedIds = new ArrayList<>();
        usedIds.addAll(studentRepository.getAllUsedIds());
        usedIds.addAll(contactPersonRepository.getAllUsedIds());
        usedIds.addAll(advisorRepository.getAllUsedIds());

        return contactDataRepository.getUnusedIds(usedIds);
    }

    @Transactional(readOnly = true)
    public List<ContactData> findAll() {
        return contactDataRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ContactData findOne(final Long contactDataId) {
        return contactDataRepository.findOne(contactDataId);
    }

    @Transactional
    public void create(final ContactData contactData) {
        contactDataRepository.create(contactData);
    }

    @Transactional
    public void update(final ContactData contactData) {
        contactDataRepository.update(contactData);
    }

    @Transactional
    public void deleteBy(final Long contactDataId) {
        final ContactData contactData = contactDataRepository.findOne(contactDataId);
        if (contactData != null) {
            contactDataRepository.delete(contactData);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
