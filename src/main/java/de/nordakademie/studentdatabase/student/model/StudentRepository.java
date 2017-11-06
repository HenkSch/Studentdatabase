package de.nordakademie.studentdatabase.student.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student findOne(Long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    public void create(final Student student) {
        entityManager.persist(student);
    }

    public void update(final Student student) {
        entityManager.merge(student);
    }

    public void delete(Student student) {
        entityManager.remove(student);
    }


    public List<Long> getAllUsedIds() {
        return entityManager.createQuery("select s.contactData.id From Student s", Long.class).getResultList();
    }
}
