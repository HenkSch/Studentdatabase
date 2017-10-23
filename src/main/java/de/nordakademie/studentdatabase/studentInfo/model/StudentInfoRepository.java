package de.nordakademie.studentdatabase.studentInfo.model;

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
}
