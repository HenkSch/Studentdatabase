package de.nordakademie.studentdatabase.studentInfo.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Repository
public class StudentInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StudentInfo> findAll() {
        return entityManager.createQuery("SELECT s FROM StudentInfo s", StudentInfo.class).getResultList();
    }

    public StudentInfo findOne(Long studentInfoId) {
        return entityManager.find(StudentInfo.class, studentInfoId);
    }

    public void create(final StudentInfo studentInfo) {
        entityManager.persist(studentInfo);
    }

    public void update(final StudentInfo studentInfo) {
        entityManager.merge(studentInfo);
    }

    public void delete(StudentInfo studentInfo) {
        entityManager.remove(studentInfo);
    }

    public List<Long> getUnusedIds(List<Long> usedIds) {
        return entityManager.createQuery("SELECT s.registrationNumber FROM StudentInfo s where s.registrationNumber not in (" + StringUtils.join(usedIds, ',') + ")", Long.class).getResultList();
    }

    public boolean isAvisorUsed(Long advisorId) {
        final List<StudentInfo> resultList = entityManager.createQuery("select s FROM StudentInfo s where s.advisor.id = " + advisorId, StudentInfo.class).getResultList();
        return (resultList.size() > 0);
    }

    public boolean isCenturyUsed(Long centuryId) {
        final List<StudentInfo> resultList = entityManager.createQuery("select s FROM StudentInfo s where s.century.id = " + centuryId, StudentInfo.class).getResultList();
        return (resultList.size() > 0);
    }

    public boolean isCompanyUsed(Long companyId) {
        final List<StudentInfo> resultList = entityManager.createQuery("select s FROM StudentInfo s where s.company.id = " + companyId, StudentInfo.class).getResultList();
        return (resultList.size() > 0);
    }
}
