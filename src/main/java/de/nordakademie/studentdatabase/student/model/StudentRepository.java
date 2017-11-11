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

    /**
     * finds all students
     *
     * @return
     */
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    /**
     * returns a student by studentId
     * @param studentId
     * @return
     */
    public Student findOne(Long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    /**
     * creates a student
     * @param student
     */
    public void create(final Student student) {
        entityManager.persist(student);
    }

    /**
     * updates a student
     * @param student
     */
    public void update(final Student student) {
        entityManager.merge(student);
    }

    /**
     * deletes a student
     * @param student
     */
    public void delete(Student student) {
        entityManager.remove(student);
    }

    /**
     * returns all used contactDataIds in student
     * @return
     */
    public List<Long> getAllUsedContactDataIds() {
        return entityManager.createQuery("select s.contactData.id From Student s", Long.class).getResultList();
    }

    /**
     * returns all used studentInfoIds in student
     * @return
     */
    public List<Long> getAllUsedStudentInfoIds() {
        return entityManager.createQuery("select s.studentInfo.registrationNumber From Student s", Long.class).getResultList();
    }

    /**
     * checks if address with addressId is used in student
     * @param addressId
     * @return
     */
    public Boolean isAddressUsed(Long addressId) {
        final List<Student> resultList = entityManager.createQuery("select s FROM Student s where s.address.id = " + addressId, Student.class).getResultList();
        return (resultList.size() > 0);
    }

    /**
     * checks if contactData with contactDataId is used in student
     * @param contactDataId
     * @return
     */
    public Boolean isContactDataUsed(Long contactDataId) {
        final List<Student> resultList = entityManager.createQuery("select s FROM Student s where s.contactData.id = " + contactDataId, Student.class).getResultList();
        return (resultList.size() > 0);
    }

    /**
     * checks if studentInfo with studentInfoId is used un student
     * @param studentInfoId
     * @return
     */
    public Boolean isStudentInfoUsed(Long studentInfoId) {
        final List<Student> resultList = entityManager.createQuery("select s FROM Student s where s.studentInfo.registrationNumber = " + studentInfoId, Student.class).getResultList();
        return (resultList.size() > 0);
    }

    /**
     * returns all students who are in century with centuryId
     * @param centuryId
     * @return
     */
    public List<Student> findAllInCentury(Long centuryId) {
        return entityManager.createQuery("select s from Student s where s.studentInfo.century.id = " + centuryId, Student.class).getResultList();
    }
}
