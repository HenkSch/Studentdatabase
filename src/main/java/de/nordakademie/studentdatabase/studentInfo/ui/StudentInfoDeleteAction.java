package de.nordakademie.studentdatabase.studentInfo.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 025, 25.10.2017.
 */
public class StudentInfoDeleteAction extends ActionSupport {

    private final StudentInfoService studentInfoService;
    private Long id;

    @Autowired
    public StudentInfoDeleteAction(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    public String deleteStudentInfo() {
        studentInfoService.deleteBy(this.id);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (studentInfoService.isUsed(this.id)) {
            addActionError(getText("studentInfo.deleteError"));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
