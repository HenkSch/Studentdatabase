package de.nordakademie.studentdatabase.studentInfo.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfo;
import de.nordakademie.studentdatabase.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 025, 25.10.2017.
 */
public class StudentInfoEditAction extends ActionSupport {

    private final StudentInfoService studentInfoService;
    private StudentInfo studentInfo;
    private Long id;

    @Autowired
    public StudentInfoEditAction(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    public String getAddForm() {
        return SUCCESS;
    }

    public String getEditForm() {
        studentInfo = studentInfoService.findOne(this.id);
        return SUCCESS;
    }

    public String createStudentInfo() {
        studentInfoService.create(this.studentInfo);
        return SUCCESS;
    }

    public String deleteStudentInfo() {
        studentInfoService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateStudentInfo() {
        studentInfoService.update(this.studentInfo);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
