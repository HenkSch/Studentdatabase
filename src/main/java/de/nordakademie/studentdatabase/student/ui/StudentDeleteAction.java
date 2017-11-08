package de.nordakademie.studentdatabase.student.ui;


import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 008, 08.11.2017.
 */
public class StudentDeleteAction extends ActionSupport {


    private final StudentService studentService;
    private Long id;

    @Autowired
    public StudentDeleteAction(StudentService studentService) {
        this.studentService = studentService;
    }


    public String deleteStudent() {
        studentService.deleteBy(this.id);
        return SUCCESS;
    }

    @Override
    public void validate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}