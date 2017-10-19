package de.nordakademie.studentdatabase.studentInfo.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Repository
public class StudentInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentInfo findOne(Long registrationNumber) {
        return entityManager.find(StudentInfo.class, registrationNumber);
    }
}
