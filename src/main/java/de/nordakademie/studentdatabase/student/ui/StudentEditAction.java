package de.nordakademie.studentdatabase.student.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.student.model.Student;
import de.nordakademie.studentdatabase.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 020, 20.10.2017.
 */
public class StudentEditAction extends ActionSupport {

    private final StudentService studentService;
    private Student student;
    private Long id;

    @Autowired
    public StudentEditAction(StudentService studentService) {
        this.studentService = studentService;
    }

    public String getAddForm() {
        return SUCCESS;
    }

    public String getEditForm() {
        student = studentService.findOne(this.id);
        return SUCCESS;
    }

    public String createStudent() {
        studentService.create(this.student);
        return SUCCESS;
    }

    public String deleteStudent() {
        studentService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateStudent() {
        studentService.update(this.student);
        return SUCCESS;
    }

    @Override
    public void validate() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
