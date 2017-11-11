package de.nordakademie.studentdatabase.studentInfo.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 019, 19.10.2017.
 */
@Repository
public class StudentInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * finds all studentInfos
     *
     * @return
     */
    public List<StudentInfo> findAll() {
        return entityManager.createQuery("SELECT s FROM StudentInfo s", StudentInfo.class).getResultList();
    }

    /**
     * returns a studentInfo by studentInfoId
     * @param studentInfoId
     * @return
     */
    public StudentInfo findOne(Long studentInfoId) {
        return entityManager.find(StudentInfo.class, studentInfoId);
    }

    /**
     * creates a studentInfo
     * @param studentInfo
     */
    public void create(final StudentInfo studentInfo) {
        entityManager.persist(studentInfo);
    }

    /**
     * updates a studentInfo
     * @param studentInfo
     */
    public void update(final StudentInfo studentInfo) {
        entityManager.merge(studentInfo);
    }

    /**
     * deletes a studentInfo
     * @param studentInfo
     */
    public void delete(StudentInfo studentInfo) {
        entityManager.remove(studentInfo);
    }

    /**
     * returns all studentInfoIds which are not in usedIds
     * @param usedIds
     * @return
     */
    public List<Long> getUnusedIds(List<Long> usedIds) {
        return entityManager.createQuery("SELECT s.registrationNumber FROM StudentInfo s where s.registrationNumber not in (" + StringUtils.join(usedIds, ',') + ")", Long.class).getResultList();
    }

    /**
     * checks if advisor with advisorId is used in studentInfo
     * @param advisorId
     * @return
     */
    public boolean isAvisorUsed(Long advisorId) {
        final List<StudentInfo> resultList = entityManager.createQuery("select s FROM StudentInfo s where s.advisor.id = " + advisorId, StudentInfo.class).getResultList();
        return (resultList.size() > 0);
    }

    /**
     * checks if century with centuryId is used in studentInfo
     * @param centuryId
     * @return
     */
    public boolean isCenturyUsed(Long centuryId) {
        final List<StudentInfo> resultList = entityManager.createQuery("select s FROM StudentInfo s where s.century.id = " + centuryId, StudentInfo.class).getResultList();
        return (resultList.size() > 0);
    }

    /**
     * checks if company with companyId is used in studentInfo
     * @param companyId
     * @return
     */
    public boolean isCompanyUsed(Long companyId) {
        final List<StudentInfo> resultList = entityManager.createQuery("select s FROM StudentInfo s where s.company.id = " + companyId, StudentInfo.class).getResultList();
        return (resultList.size() > 0);
    }
}
