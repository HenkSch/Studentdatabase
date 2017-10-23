package de.nordakademie.studentdatabase.advisor.service;

import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.advisor.model.AdvisorRepository;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.model.ContactDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
@Service
public class AdvisorService {

    private final AdvisorRepository advisorRepository;
    private final ContactDataRepository contactDataRepository;
    private Long id;

    @Autowired
    public AdvisorService(AdvisorRepository advisorRepository, ContactDataRepository contactDataRepository) {
        this.advisorRepository = advisorRepository;
        this.contactDataRepository = contactDataRepository;
    }

    @Transactional(readOnly = true)
    public List<Advisor> findAll() {
        return advisorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Advisor findOne(final Long advisorId) {
        return advisorRepository.findOne(advisorId);
    }

    @Transactional
    public void create(final Advisor advisor) {
        final ContactData contactData = contactDataRepository.findOne(advisor.getContactData().getId());
        advisor.setContactData(contactData);

        advisorRepository.create(advisor);
    }

    @Transactional
    public void update(final Advisor advisor) {
        advisorRepository.update(advisor);
    }

    @Transactional
    public void deleteBy(final Long advisorId) {
        final Advisor advisor = advisorRepository.findOne(advisorId);
        if (advisor != null) {
            advisorRepository.delete(advisor);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
