package de.nordakademie.studentdatabase.studentInfo.service;

import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.advisor.model.AdvisorRepository;
import de.nordakademie.studentdatabase.century.model.Century;
import de.nordakademie.studentdatabase.century.model.CenturyRepository;
import de.nordakademie.studentdatabase.company.model.Company;
import de.nordakademie.studentdatabase.company.model.CompanyRepository;
import de.nordakademie.studentdatabase.student.model.StudentRepository;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfo;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
@Service
public class StudentInfoService {

    private final StudentInfoRepository studentInfoRepository;
    private final StudentRepository studentRepository;
    private final CenturyRepository centuryRepository;
    private final AdvisorRepository advisorRepository;
    private final CompanyRepository companyRepository;
    private Long id;

    @Autowired
    public StudentInfoService(StudentInfoRepository studentInfoRepository, StudentRepository studentRepository, CenturyRepository centuryRepository, AdvisorRepository advisorRepository, CompanyRepository companyRepository) {
        this.studentInfoRepository = studentInfoRepository;
        this.studentRepository = studentRepository;
        this.centuryRepository = centuryRepository;
        this.advisorRepository = advisorRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    public List<StudentInfo> findAll() {
        return studentInfoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public StudentInfo findOne(final Long studentInfoId) {
        return studentInfoRepository.findOne(studentInfoId);
    }

    @Transactional
    public void create(final StudentInfo studentInfo) {
        final Century century = centuryRepository.findOne(studentInfo.getCentury().getId());
        studentInfo.setCentury(century);

        final Long advisorId = studentInfo.getAdvisor().getId();
        if (advisorId != null) {
            final Advisor advisor = advisorRepository.findOne(advisorId);
            studentInfo.setAdvisor(advisor);
        } else {
            studentInfo.setAdvisor(null);
        }


        final Long companyId = studentInfo.getCompany().getId();
        if (companyId != null) {
            final Company company = companyRepository.findOne(companyId);
            studentInfo.setCompany(company);
        } else {
            studentInfo.setCompany(null);
        }

        studentInfoRepository.create(studentInfo);
    }

    @Transactional
    public void update(final StudentInfo studentInfo) {
        if (studentInfo.getAdvisor().getId() == null) {
            studentInfo.setAdvisor(null);
        }
        if (studentInfo.getCompany().getId() == null) {
            studentInfo.setCompany(null);
        }

        studentInfoRepository.update(studentInfo);
    }

    @Transactional
    public void deleteBy(final Long studentInfoId) {
        final StudentInfo studentInfo = studentInfoRepository.findOne(studentInfoId);
        if (studentInfo != null) {
            studentInfoRepository.delete(studentInfo);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Transactional
    public List<Long> getUnusedIds() {
        final List<Long> usedStudentInfoIds = new ArrayList<>();
        usedStudentInfoIds.addAll(studentRepository.getAllUsedStudentInfoIds());
        usedStudentInfoIds.removeAll(Collections.singleton(null));

        return studentInfoRepository.getUnusedIds(usedStudentInfoIds);
    }

    @Transactional
    public boolean isUsed(Long studentInfoId) {
        return studentRepository.isStudentInfoUsed(studentInfoId);
    }
}
