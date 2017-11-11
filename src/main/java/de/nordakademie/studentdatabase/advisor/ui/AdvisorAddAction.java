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

    /**
     * Constructor
     *
     * @param advisorService
     * @param contactDataService
     */
    @Autowired
    public AdvisorAddAction(AdvisorService advisorService, ContactDataService contactDataService) {
        this.advisorService = advisorService;
        this.contactDataService = contactDataService;
    }

    /**
     * fills dropdown lists
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
        this.contactDataList = contactDataService.getUnusedIds();
    }

    /**
     * creates an advisor
     * @return
     */
    public String createAdvisor() {
        advisorService.create(this.advisor);
        return SUCCESS;
    }

    /**
     * fills list so they are filled after validation Error
     */
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
