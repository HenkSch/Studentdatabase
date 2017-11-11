package de.nordakademie.studentdatabase.studentInfo.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.advisor.service.AdvisorService;
import de.nordakademie.studentdatabase.century.service.CenturyService;
import de.nordakademie.studentdatabase.company.service.CompanyService;
import de.nordakademie.studentdatabase.studentInfo.model.StudentInfo;
import de.nordakademie.studentdatabase.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 025, 25.10.2017.
 */
public class StudentInfoAddAction extends ActionSupport {

    private final StudentInfoService studentInfoService;
    private final CenturyService centuryService;
    private final CompanyService companyService;
    private final AdvisorService advisorService;
    private StudentInfo studentInfo;
    private List<Long> centuryList = new ArrayList<>();
    private List<Long> companyList = new ArrayList<>();
    private List<Long> advisorList = new ArrayList<>();

    /**
     * Constructor
     *
     * @param studentInfoService
     * @param centuryService
     * @param companyService
     * @param advisorService
     */
    @Autowired
    public StudentInfoAddAction(StudentInfoService studentInfoService, CenturyService centuryService, CompanyService companyService, AdvisorService advisorService) {
        this.studentInfoService = studentInfoService;
        this.centuryService = centuryService;
        this.companyService = companyService;
        this.advisorService = advisorService;
    }

    /**
     * fills drop down lists
     * @return
     */
    public String getForm() {

        fillLists();

        return SUCCESS;
    }

    /**
     * fills dropdown lists
     */
    private void fillLists() {
        centuryList = centuryService.getAllIds();
        companyList = companyService.getAllIds();
        advisorList = advisorService.getAllIds();
    }

    /**
     * creates a studentInfo
     * @return
     */
    public String createStudentInfo() {
        studentInfoService.create(this.studentInfo);
        return SUCCESS;
    }

    /**
     * fills dropdown lists so they are used after validationError
     */
    @Override
    public void validate() {
        fillLists();
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public List<Long> getCenturyList() {
        return centuryList;
    }

    public void setCenturyList(List<Long> centuryList) {
        this.centuryList = centuryList;
    }

    public List<Long> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Long> companyList) {
        this.companyList = companyList;
    }

    public List<Long> getAdvisorList() {
        return advisorList;
    }

    public void setAdvisorList(List<Long> advisorList) {
        this.advisorList = advisorList;
    }
}
