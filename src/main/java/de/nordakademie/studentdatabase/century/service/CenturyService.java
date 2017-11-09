package de.nordakademie.studentdatabase.century.service;

import de.nordakademie.studentdatabase.century.model.Century;
import de.nordakademie.studentdatabase.century.model.CenturyRepository;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
@Service
public class CenturyService {
    private final CenturyRepository centuryRepository;
    private final StudentInfoRepository studentInfoRepository;
    private Long id;

    @Autowired
    public CenturyService(CenturyRepository centuryRepository, StudentInfoRepository studentInfoRepository) {
        this.centuryRepository = centuryRepository;
        this.studentInfoRepository = studentInfoRepository;
    }

    @Transactional
    public List<Long> getAllIds() {
        return centuryRepository.getAllIds();
    }

    @Transactional(readOnly = true)
    public List<Century> findAll() {
        return centuryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Century findOne(final Long centuryId) {
        return centuryRepository.findOne(centuryId);
    }

    @Transactional
    public void create(final Century century) {
        centuryRepository.create(century);
    }

    @Transactional
    public void update(final Century century) {
        centuryRepository.update(century);
    }

    @Transactional
    public void deleteBy(final Long centuryId) {
        final Century century = centuryRepository.findOne(centuryId);
        if (century != null) {
            centuryRepository.delete(century);
        }
    }

    @Transactional
    public boolean isUsed(Long centuryId) {
        return studentInfoRepository.isCenturyUsed(centuryId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
