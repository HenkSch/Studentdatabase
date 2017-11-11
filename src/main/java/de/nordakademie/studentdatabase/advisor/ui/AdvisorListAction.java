package de.nordakademie.studentdatabase.advisor.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.advisor.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 024, 24.10.2017.
 */
public class AdvisorListAction implements Action {

    private final AdvisorService advisorService;
    private List<Advisor> advisorList;

    @Autowired
    public AdvisorListAction(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @Override
    public String execute() {
        advisorList = advisorService.findAll();
        return SUCCESS;
    }

    public List<Advisor> getAdvisorList() {
        return advisorList;
    }
}
