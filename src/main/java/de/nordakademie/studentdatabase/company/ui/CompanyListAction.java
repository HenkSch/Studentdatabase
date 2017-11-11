package de.nordakademie.studentdatabase.company.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.company.model.Company;
import de.nordakademie.studentdatabase.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 024, 24.10.2017.
 */
public class CompanyListAction implements Action {
    private final CompanyService companyService;
    private List<Company> companyList;

    @Autowired
    public CompanyListAction(CompanyService companyService) {
        this.companyService = companyService;
    }


    @Override
    public String execute() throws Exception {
        companyList = companyService.findAll();
        return SUCCESS;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }
}
