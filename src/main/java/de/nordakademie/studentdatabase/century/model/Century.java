package de.nordakademie.studentdatabase.century.model;

import javax.persistence.*;

/**
 * Created by Henk Schuhmann on 019, 19.10.2017.
 */
@Entity
@Table(name = "CENTURY")
public class Century {

    private Long id;
    private String studyProgram;
    private Integer year;
    private String subGroup;

    public Century() {
    }

    public Century(Long id, String studyProgram, Integer year, String subGroup) {
        this.id = id;
        this.studyProgram = studyProgram;
        this.year = year;
        this.subGroup = subGroup;
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
    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    @Basic
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }
}
