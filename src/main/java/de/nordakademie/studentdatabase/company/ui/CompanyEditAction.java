package de.nordakademie.studentdatabase.company.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.company.model.Company;
import de.nordakademie.studentdatabase.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 024, 24.10.2017.
 */
public class CompanyEditAction extends ActionSupport {
    private final CompanyService companyService;
    private Company company;
    private Long id;

    @Autowired
    public CompanyEditAction(CompanyService companyService) {
        this.companyService = companyService;
    }

    public String getAddForm() {
        return SUCCESS;
    }

    public String getEditForm() {
        company = companyService.findOne(this.id);
        return SUCCESS;
    }

    public String createCompany() {
        companyService.create(this.company);
        return SUCCESS;
    }

    public String deleteCompany() {
        companyService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateCompany() {
        companyService.update(this.company);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
