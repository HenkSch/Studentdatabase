package de.nordakademie.studentdatabase.studentInfo.model;

import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.century.model.Century;
import de.nordakademie.studentdatabase.company.model.Company;

import javax.persistence.*;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 019, 19.10.2017.
 */
@Entity
@Table(name = "STUDENTINFO")
public class StudentInfo {

    private Long registrationNumber;
    private Integer userNumber;
    private Century century;
    private Advisor advisor;
    private Company company;

    /**
     * Constructor
     */
    public StudentInfo() {
    }

    /**
     * Constructor
     *
     * @param registrationNumber
     * @param userNumber
     * @param century
     * @param advisor
     * @param company
     */
    public StudentInfo(Long registrationNumber, Integer userNumber, Century century, Advisor advisor, Company company) {
        this.registrationNumber = registrationNumber;
        this.userNumber = userNumber;
        this.century = century;
        this.advisor = advisor;
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Basic
    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    @ManyToOne(optional = false)
    public Century getCentury() {
        return century;
    }

    public void setCentury(Century century) {
        this.century = century;
    }

    @ManyToOne
    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
