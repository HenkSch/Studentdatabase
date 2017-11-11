package de.nordakademie.studentdatabase.company.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 024, 24.10.2017.
 */
public class CompanyDeleteAction extends ActionSupport {
    private final CompanyService companyService;
    private Long id;

    @Autowired
    public CompanyDeleteAction(CompanyService companyService) {
        this.companyService = companyService;
    }


    public String deleteCompany() {
        companyService.deleteBy(this.id);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (companyService.isUsed(this.id)) {
            addActionError(getText("company.deleteError"));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
