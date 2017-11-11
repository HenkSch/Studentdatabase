package de.nordakademie.studentdatabase.student.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.student.model.Student;
import de.nordakademie.studentdatabase.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 023, 23.10.2017.
 */
public class StudentAttendanceListAction implements Action {

    private final StudentService studentService;
    private List<Student> studentList;
    private Long centuryId;

    /**
     * Constructor
     *
     * @param studentService
     */
    @Autowired
    public StudentAttendanceListAction(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * finds all students in century with centuryId
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        studentList = studentService.findAllInCentury(centuryId);
        return SUCCESS;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Long getCenturyId() {
        return centuryId;
    }

    public void setCenturyId(Long centuryId) {
        this.centuryId = centuryId;
    }
}
