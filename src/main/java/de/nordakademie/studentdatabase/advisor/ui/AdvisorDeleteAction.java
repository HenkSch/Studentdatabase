package de.nordakademie.studentdatabase.advisor.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.advisor.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann on 024, 24.10.2017.
 */
public class AdvisorDeleteAction extends ActionSupport {
    private final AdvisorService advisorService;
    private Long id;

    @Autowired
    public AdvisorDeleteAction(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }


    public String deleteAdvisor() {
        advisorService.deleteBy(this.id);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (advisorService.isUsed(this.id)) {
            addActionError(getText("advisor.deleteError"));
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
