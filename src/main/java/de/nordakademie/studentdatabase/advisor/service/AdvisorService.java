package de.nordakademie.studentdatabase.advisor.service;

import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.advisor.model.AdvisorRepository;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.model.ContactDataRepository;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 023, 23.10.2017.
 */
@Service
public class AdvisorService {

    private final AdvisorRepository advisorRepository;
    private final ContactDataRepository contactDataRepository;
    private final StudentInfoRepository studentInfoRepository;
    private Long id;

    /**
     * Constructor
     *
     * @param advisorRepository
     * @param contactDataRepository
     * @param studentInfoRepository
     */
    @Autowired
    public AdvisorService(AdvisorRepository advisorRepository, ContactDataRepository contactDataRepository, StudentInfoRepository studentInfoRepository) {
        this.advisorRepository = advisorRepository;
        this.contactDataRepository = contactDataRepository;
        this.studentInfoRepository = studentInfoRepository;
    }

    /**
     * returns all advisorIds
     * @return
     */
    @Transactional
    public List<Long> getAllIds() {
        return advisorRepository.getAllIds();
    }

    /**
     * finds all advisors
     * @return
     */
    @Transactional(readOnly = true)
    public List<Advisor> findAll() {
        return advisorRepository.findAll();
    }

    /**
     * returns one advisor by advisorId
     * @param advisorId
     * @return
     */
    @Transactional(readOnly = true)
    public Advisor findOne(final Long advisorId) {
        return advisorRepository.findOne(advisorId);
    }

    /**
     * creates an advisor
     * @param advisor
     */
    @Transactional
    public void create(final Advisor advisor) {
        final ContactData contactData = contactDataRepository.findOne(advisor.getContactData().getId());
        advisor.setContactData(contactData);

        advisorRepository.create(advisor);
    }

    /**
     * updates an advisor
     * @param advisor
     */
    @Transactional
    public void update(final Advisor advisor) {
        advisorRepository.update(advisor);
    }

    /**
     * deletes an advisor by advisorId
     * @param advisorId
     */
    @Transactional
    public void deleteBy(final Long advisorId) {
        final Advisor advisor = advisorRepository.findOne(advisorId);
        if (advisor != null) {
            advisorRepository.delete(advisor);
        }
    }

    /**
     * checks if advisor with advisorId is used
     * @param advisorId
     * @return
     */
    @Transactional
    public boolean isUsed(Long advisorId) {
        return studentInfoRepository.isAvisorUsed(advisorId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
