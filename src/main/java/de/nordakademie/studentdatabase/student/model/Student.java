package de.nordakademie.studentdatabase.student.model;

import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Henk Schuhmann on 019, 19.10.2017.
 */
@Entity
@Table(name = "STUDENT")
public class Student {

    private Long id;
    private String name;
    private String givenName;
    private String gender;
    private Date birthDate;
    private String birthPlace;
    private StudentInfo studentInfo;
    private Address address;
    private ContactData contactData;

    public Student() {
    }

    public Student(Long id, String name, String givenName, String gender, Date birthDate, String birthPlace, StudentInfo studentInfo, Address address, ContactData contactData) {
        this.id = id;
        this.name = name;
        this.givenName = givenName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.studentInfo = studentInfo;
        this.address = address;
        this.contactData = contactData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Basic
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @OneToOne
    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    @ManyToOne(optional = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToOne(optional = false)
    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }
}
