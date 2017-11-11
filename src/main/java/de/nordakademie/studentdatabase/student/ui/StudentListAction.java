package de.nordakademie.studentdatabase.student.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.student.model.Student;
import de.nordakademie.studentdatabase.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 020, 20.10.2017.
 */

public class StudentListAction implements Action {

    private final StudentService studentService;
    private List<Student> studentList;

    private String searchValue = "";

    /**
     * Constructor
     *
     * @param studentService
     */
    @Autowired
    public StudentListAction(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * finds a student by id and searches for searchValue
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        studentList = studentService.findAll();
        studentList = doSearch(searchValue, studentList);

        return SUCCESS;
    }

    /**
     * removes student from studentlist if they do not match searchValue
     * search can match "Name", "GivenName", "Name GivenName" or "GivenName Name" as searchValue
     */
    private List<Student> doSearch(String searchValue, List<Student> studentList) {
        final String trimmedSearchValue = searchValue.replaceAll("\\s+", " ").toLowerCase();

        for (int i = studentList.size() - 1; i >= 0; i--) {
            Student student = studentList.get(i);

            final String lowerCaseGivenName = student.getGivenName().toLowerCase();
            final String lowerCaseName = student.getName().toLowerCase();

            final boolean givenName_name = (lowerCaseGivenName + lowerCaseName).contains(trimmedSearchValue);
            final boolean name_givenName = (lowerCaseName + lowerCaseGivenName).contains(trimmedSearchValue);
            if (givenName_name || name_givenName) {
            } else {
                studentList.remove(i);
            }
        }
        return studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
