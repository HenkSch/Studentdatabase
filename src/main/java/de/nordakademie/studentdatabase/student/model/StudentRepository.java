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

    public void create(final Student student) {
        entityManager.persist(student);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student findOne(final Long id) {
        return entityManager.find(Student.class, id);
    }

    public void remove(final Student student) {
        entityManager.remove(student);
    }
}
