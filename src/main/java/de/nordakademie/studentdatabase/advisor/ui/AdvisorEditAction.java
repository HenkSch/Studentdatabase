package de.nordakademie.studentdatabase.advisor.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.advisor.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 024, 24.10.2017.
 */
public class AdvisorEditAction extends ActionSupport {
    private final AdvisorService advisorService;
    private Advisor advisor;
    private Long id;

    @Autowired
    public AdvisorEditAction(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    public String getAddForm() {
        return SUCCESS;
    }

    public String getEditForm() {
        advisor = advisorService.findOne(this.id);
        return SUCCESS;
    }

    public String createAdvisor() {
        advisorService.create(this.advisor);
        return SUCCESS;
    }

    public String deleteAdvisor() {
        advisorService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateAdvisor() {
        advisorService.update(this.advisor);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
