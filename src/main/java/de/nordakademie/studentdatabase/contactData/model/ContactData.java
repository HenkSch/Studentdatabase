package de.nordakademie.studentdatabase.contactData.model;

import javax.persistence.*;

/**
 * Created by Henk Schuhmann on 019, 19.10.2017.
 */
@Entity
@Table(name = "CONTACTDATA")
public class ContactData {

    private Long id;
    private String email;
    private String phoneNumber;
    private String faxNumber;

    public ContactData(Long id, String email, String phoneNumber, String faxNumber) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
    }

    public ContactData() {
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
}
