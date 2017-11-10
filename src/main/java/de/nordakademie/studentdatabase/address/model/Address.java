package de.nordakademie.studentdatabase.address.model;

import javax.persistence.*;

/**
 * Created by Henk Schuhmann on 019, 19.10.2017.
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

    private Long id;
    private String street;
    private String houseNumber;
    private Integer zipCode;
    private String location;
    private String addition;


    public Address() {
    }

    public Address(Long id, String street, String houseNumber, Integer zipCode, String location, String addition) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.location = location;
        this.addition = addition;
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
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Basic
    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }
}
