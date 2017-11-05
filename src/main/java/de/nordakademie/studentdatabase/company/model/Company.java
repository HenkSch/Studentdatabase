package de.nordakademie.studentdatabase.company.model;

import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.contactData.model.ContactData;

import javax.persistence.*;

/**
 * Created by U555987 on 019, 19.10.2017.
 */
@Entity
@Table(name = "COMPANY")
public class Company {

    private Long id;
    private String name;
    private String shortName;
    private String contactPerson;
    private ContactData contactData;
    private Address address;

    public Company() {
    }

    public Company(Long id, String name, String shortName, String contactPerson, ContactData contactData, Address address) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.contactPerson = contactPerson;
        this.contactData = contactData;
        this.address = address;
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
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @OneToOne(optional = false)
    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    @ManyToOne(optional = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
