package de.nordakademie.studentdatabase.contactData.service;

import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.model.ContactDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by U555987 on 020, 20.10.2017.
 */
@Service
public class ContactDataService {

    private final ContactDataRepository contactDataRepository;
    private Long id;

    @Autowired
    public ContactDataService(ContactDataRepository contactDataRepository) {
        this.contactDataRepository = contactDataRepository;
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
    public void save(final ContactData contactData) {
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
