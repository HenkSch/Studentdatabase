package de.nordakademie.studentdatabase.company.model;

import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPerson;

import javax.persistence.*;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 019, 19.10.2017.
 */
@Entity
@Table(name = "COMPANY")
public class Company {

    private Long id;
    private String name;
    private String shortName;
    private ContactPerson contactPerson;
    private Address address;

    public Company() {
    }

    public Company(Long id, String name, String shortName, ContactPerson contactPerson, Address address) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.contactPerson = contactPerson;
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

    @OneToOne(optional = false)
    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    @ManyToOne(optional = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
