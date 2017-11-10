package de.nordakademie.studentdatabase.contactData.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 020, 20.10.2017.
 */
public class ContactDataDeleteAction extends ActionSupport {

    private final ContactDataService contactDataService;

    private Long id;

    @Autowired
    public ContactDataDeleteAction(ContactDataService contactDataService) {
        this.contactDataService = contactDataService;
    }


    public String deleteContactData() {
        contactDataService.deleteBy(this.id);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (contactDataService.isUsed(this.id)) {
            addActionError(getText("contactData.deleteError"));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
