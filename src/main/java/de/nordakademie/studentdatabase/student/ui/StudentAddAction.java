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
 * Created by Henk Schuhmann, Sarah Bruhn on 008, 08.11.2017.
 */
public class StudentAddAction extends ActionSupport {

    private final StudentService studentService;
    private final AddressService addressService;
    private final ContactDataService contactDataService;
    private final StudentInfoService studentInfoService;

    private Student student;
    private List<Long> addressList = new ArrayList();
    private List<Long> contactDataList = new ArrayList();
    private List<Long> studentInfoList = new ArrayList();
    private List<String> genderList = Gender.getGenderList();

    /**
     * Constructor
     *
     * @param studentService
     * @param addressService
     * @param contactDataService
     * @param studentInfoService
     */
    @Autowired
    public StudentAddAction(StudentService studentService, AddressService addressService, ContactDataService contactDataService, StudentInfoService studentInfoService) {
        this.studentService = studentService;
        this.addressService = addressService;
        this.contactDataService = contactDataService;
        this.studentInfoService = studentInfoService;

    }

    /**
     * fills dropdown lists
     * @return
     */
    public String getForm() {
        fillLists();

        return SUCCESS;
    }

    /**
     * fills dropdown lists
     */
    private void fillLists() {
        addressList = addressService.getAllIds();
        contactDataList = contactDataService.getUnusedIds();
        studentInfoList = studentInfoService.getUnusedIds();
    }

    /**
     * creates a student
     * @return
     */
    public String createStudent() {
        studentService.create(this.student);
        return SUCCESS;
    }

    /**
     * fills dropdown lists so they are filled after validationError
     */
    @Override
    public void validate() {
        fillLists();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
