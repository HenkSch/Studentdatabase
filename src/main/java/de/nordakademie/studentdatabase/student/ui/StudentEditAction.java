package de.nordakademie.studentdatabase.student.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.address.service.AddressService;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import de.nordakademie.studentdatabase.student.model.Student;
import de.nordakademie.studentdatabase.student.service.StudentService;
import de.nordakademie.studentdatabase.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U555987 on 020, 20.10.2017.
 */
public class StudentEditAction extends ActionSupport {

    private final StudentService studentService;
    private final AddressService addressService;
    private final ContactDataService contactDataService;
    private final StudentInfoService studentInfoService;
    private Student student;
    private Long id;
    private List<Long> addressList;
    private List<Long> contactDataList;
    private List<Long> studentInfoList;

    @Autowired
    public StudentEditAction(StudentService studentService, AddressService addressService, ContactDataService contactDataService, StudentInfoService studentInfoService) {
        this.studentService = studentService;
        this.addressService = addressService;
        this.contactDataService = contactDataService;
        this.studentInfoService = studentInfoService;
    }

    public String getAddForm() {
        addressList = addressService.getAllIds();

        contactDataList = contactDataService.getUnusedIds();

        studentInfoList = studentInfoService.getUnusedIds();

        return SUCCESS;
    }

    public String getEditForm() {
        student = studentService.findOne(this.id);

        addressList = addressService.getAllIds();

        contactDataList = new ArrayList<>();
        contactDataList.add(this.student.getContactData().getId());
        contactDataList.addAll(contactDataService.getUnusedIds());

        studentInfoList = new ArrayList<>();
        if (this.student.getStudentInfo() != null) {
            studentInfoList.add(this.student.getStudentInfo().getRegistrationNumber());
        }
        studentInfoList.addAll(studentInfoService.getUnusedIds());


        return SUCCESS;
    }

    public String createStudent() {
        studentService.create(this.student);
        return SUCCESS;
    }

    public String deleteStudent() {
        studentService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateStudent() {
        studentService.update(this.student);
        return SUCCESS;
    }

    @Override
    public void validate() {
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
}
