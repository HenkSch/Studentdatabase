package de.nordakademie.studentdatabase.advisor.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.advisor.service.AdvisorService;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 024, 24.10.2017.
 */
public class AdvisorAddAction extends ActionSupport {
    private final AdvisorService advisorService;
    private final ContactDataService contactDataService;
    private Advisor advisor;
    private List<Long> contactDataList = new ArrayList<>();

    @Autowired
    public AdvisorAddAction(AdvisorService advisorService, ContactDataService contactDataService) {
        this.advisorService = advisorService;
        this.contactDataService = contactDataService;
    }

    public String getForm() {
        fillLists();
        return SUCCESS;
    }

    private void fillLists() {
        this.contactDataList = contactDataService.getUnusedIds();
    }

    public String createAdvisor() {
        advisorService.create(this.advisor);
        return SUCCESS;
    }

    @Override
    public void validate() {
        fillLists();
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public List<Long> getContactDataList() {
        return contactDataList;
    }

    public void setContactDataList(List<Long> contactDataList) {
        this.contactDataList = contactDataList;
    }
}
