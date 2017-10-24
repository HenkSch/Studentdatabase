package de.nordakademie.studentdatabase.advisor.model;

import de.nordakademie.studentdatabase.contactData.model.ContactData;

import javax.persistence.*;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Entity
@Table(name = "ADVISOR")
public class Advisor {

    private Long id;
    private String name;
    private String givenName;
    private ContactData contactData;

    public Advisor() {
    }

    public Advisor(Long id, String name, String givenName, ContactData contactData) {
        this.id = id;
        this.name = name;
        this.givenName = givenName;
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

    @OneToOne(optional = false)
    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }
}
