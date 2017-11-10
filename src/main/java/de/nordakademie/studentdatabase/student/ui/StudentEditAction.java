package de.nordakademie.studentdatabase.student.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.address.service.AddressService;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import de.nordakademie.studentdatabase.gender.Gender;
import de.nordakademie.studentdatabase.student.model.Student;
import de.nordakademie.studentdatabase.student.service.StudentService;
import de.nordakademie.studentdatabase.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henk Schuhmann on 020, 20.10.2017.
 */
public class StudentEditAction extends ActionSupport {

    private final StudentService studentService;
    private final AddressService addressService;
    private final ContactDataService contactDataService;
    private final StudentInfoService studentInfoService;
    private Student student;
    private Long id;
    private List<Long> addressList = new ArrayList();
    private List<Long> contactDataList = new ArrayList();
    private List<Long> studentInfoList = new ArrayList();
    private List<String> genderList = Gender.getGenderList();

    @Autowired
    public StudentEditAction(StudentService studentService, AddressService addressService, ContactDataService contactDataService, StudentInfoService studentInfoService) {
        this.studentService = studentService;
        this.addressService = addressService;
        this.contactDataService = contactDataService;
        this.studentInfoService = studentInfoService;
    }

    public String getForm() {
        this.student = studentService.findOne(this.id);

        fillLists(this.student);

        return SUCCESS;
    }

    private void fillLists(Student student) {
        this.addressList = addressService.getAllIds();

        this.contactDataList = new ArrayList<>();
        this.contactDataList.add(student.getContactData().getId());
        this.contactDataList.addAll(contactDataService.getUnusedIds());

        this.studentInfoList = new ArrayList<>();
        if (student.getStudentInfo() != null) {
            this.studentInfoList.add(student.getStudentInfo().getRegistrationNumber());
        }
        this.studentInfoList.addAll(studentInfoService.getUnusedIds());
    }

    public String updateStudent() {
        studentService.update(this.student);
        return SUCCESS;
    }

    @Override
    public void validate() {
        Student tempStudent = studentService.findOne(this.id);
        fillLists(tempStudent);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Long> addressList) {
        this.addressList = addressList;
    }

    public List<Long> getContactDataList() {
        return contactDataList;
    }

    public void setContactDataList(List<Long> contactDataList) {
        this.contactDataList = contactDataList;
    }

    public List<Long> getStudentInfoList() {
        return studentInfoList;
    }

    public void setStudentInfoList(List<Long> studentInfoList) {
        this.studentInfoList = studentInfoList;
    }

    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }
}
