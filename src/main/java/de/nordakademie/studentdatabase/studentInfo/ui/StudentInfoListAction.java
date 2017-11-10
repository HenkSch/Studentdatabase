package de.nordakademie.studentdatabase.studentInfo.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfo;
import de.nordakademie.studentdatabase.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann on 025, 25.10.2017.
 */
public class StudentInfoListAction implements Action {

    private final StudentInfoService studentInfoService;
    private List<StudentInfo> studentInfoList;

    @Autowired
    public StudentInfoListAction(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }


    @Override
    public String execute() throws Exception {
        studentInfoList = studentInfoService.findAll();
        return SUCCESS;
    }

    public List<StudentInfo> getStudentInfoList() {
        return studentInfoList;
    }
}
