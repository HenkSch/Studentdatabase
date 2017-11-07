package de.nordakademie.studentdatabase.advisor.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.advisor.model.Advisor;
import de.nordakademie.studentdatabase.advisor.service.AdvisorService;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U555987 on 024, 24.10.2017.
 */
public class AdvisorEditAction extends ActionSupport {
    private final AdvisorService advisorService;
    private final ContactDataService contactDataService;
    private Advisor advisor;
    private Long id;
    private List<Long> contactDataList;

    @Autowired
    public AdvisorEditAction(AdvisorService advisorService, ContactDataService contactDataService) {
        this.advisorService = advisorService;
        this.contactDataService = contactDataService;
    }

    public String getAddForm() {
        this.contactDataList = contactDataService.getUnusedIds();
        return SUCCESS;
    }

    public String getEditForm() {
        advisor = advisorService.findOne(this.id);

        this.contactDataList = new ArrayList<>();
        this.contactDataList.add(this.advisor.getContactData().getId());
        this.contactDataList.addAll(contactDataService.getUnusedIds());

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

    public List<Long> getContactDataList() {
        return contactDataList;
    }

    public void setContactDataList(List<Long> contactDataList) {
        this.contactDataList = contactDataList;
    }
}
