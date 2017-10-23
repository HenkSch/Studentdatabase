package de.nordakademie.studentdatabase.student.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.student.model.Student;
import de.nordakademie.studentdatabase.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by U555987 on 020, 20.10.2017.
 */

public class StudentListAction implements Action {

    private final StudentService studentService;

    private List<Student> students;

    @Autowired
    public StudentListAction(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public String execute() throws Exception {
        students = studentService.findAll();
        return SUCCESS;
    }

    public List<Student> getStudents() {
        return students;
    }
}
