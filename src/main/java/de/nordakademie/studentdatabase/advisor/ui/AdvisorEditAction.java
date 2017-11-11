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
public class AdvisorEditAction extends ActionSupport {
    private final AdvisorService advisorService;
    private final ContactDataService contactDataService;
    private Advisor advisor;
    private Long id;
    private List<Long> contactDataList = new ArrayList<>();

    /**
     * Constructor
     *
     * @param advisorService
     * @param contactDataService
     */
    @Autowired
    public AdvisorEditAction(AdvisorService advisorService, ContactDataService contactDataService) {
        this.advisorService = advisorService;
        this.contactDataService = contactDataService;
    }

    /**
     * finds one advisor by id and fills dropdown lists
     * @return
     */
    public String getForm() {
        advisor = advisorService.findOne(this.id);

        fillLists(this.advisor);

        return SUCCESS;
    }

    /**
     * fills dropdown lists
     * @param advisor
     */
    private void fillLists(Advisor advisor) {
        this.contactDataList = new ArrayList<>();
        this.contactDataList.add(advisor.getContactData().getId());
        this.contactDataList.addAll(contactDataService.getUnusedIds());
    }

    /**
     * updates an advisor
     * @return
     */
    public String updateAdvisor() {
        advisorService.update(this.advisor);
        return SUCCESS;
    }

    /**
     * fills dropdown lists they are filled after validationError
     */
    @Override
    public void validate() {
        Advisor tempAdvisor = advisorService.findOne(this.id);
        fillLists(tempAdvisor);
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

    public List<Long> getContactDataList() {
        return contactDataList;
    }

    public void setContactDataList(List<Long> contactDataList) {
        this.contactDataList = contactDataList;
    }
}
