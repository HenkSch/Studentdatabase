package de.nordakademie.studentdatabase.student.service;

import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.address.model.AddressRepository;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.model.ContactDataRepository;
import de.nordakademie.studentdatabase.student.model.Student;
import de.nordakademie.studentdatabase.student.model.StudentRepository;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfo;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentInfoRepository studentInfoRepository;
    private final AddressRepository addressRepository;
    private final ContactDataRepository contactDataRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentInfoRepository studentInfoRepository, AddressRepository addressRepository, ContactDataRepository contactDataRepository) {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
        this.addressRepository = addressRepository;
        this.contactDataRepository = contactDataRepository;
    }

    @Transactional
    public Student findOne(final Long id) {
        return studentRepository.findOne(id);
    }

    @Transactional
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public void create(final Student student) {
        final StudentInfo studentInfo = studentInfoRepository.findOne(student.getStudentInfo().getRegistrationNumber());
        student.setStudentInfo(studentInfo);

        final Address address = addressRepository.findOne(student.getAddress().getId());
        student.setAddress(address);

        final ContactData contactData = contactDataRepository.findOne((student.getContactData().getId()));
        student.setContactData(contactData);

        studentRepository.create(student);
    }

    @Transactional
    public void deleteBy(Long id) {
        Student student = studentRepository.findOne(id);
        if (student != null) {
            studentRepository.delete(student);
        }
    }


}
