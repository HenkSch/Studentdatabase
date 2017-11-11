package de.nordakademie.studentdatabase.student.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 019, 19.10.2017.
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

    public List<Long> getAllUsedContactDataIds() {
        return entityManager.createQuery("select s.contactData.id From Student s", Long.class).getResultList();
    }

    public List<Long> getAllUsedStudentInfoIds() {
        return entityManager.createQuery("select s.studentInfo.registrationNumber From Student s", Long.class).getResultList();
    }

    public Boolean isAddressUsed(Long addressId) {
        final List<Student> resultList = entityManager.createQuery("select s FROM Student s where s.address.id = " + addressId, Student.class).getResultList();
        return (resultList.size() > 0);
    }

    public Boolean isContactDataUsed(Long contactDataId) {
        final List<Student> resultList = entityManager.createQuery("select s FROM Student s where s.contactData.id = " + contactDataId, Student.class).getResultList();
        return (resultList.size() > 0);
    }

    public Boolean isStudentInfoUsed(Long studentInfoId) {
        final List<Student> resultList = entityManager.createQuery("select s FROM Student s where s.studentInfo.registrationNumber = " + studentInfoId, Student.class).getResultList();
        return (resultList.size() > 0);
    }

    public List<Student> findAllInCentury(Long centuryId) {
        return entityManager.createQuery("select s from Student s where s.studentInfo.century.id = " + centuryId, Student.class).getResultList();
    }
}
