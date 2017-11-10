package de.nordakademie.studentdatabase.contactPerson.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactPerson.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann on 006, 06.11.2017.
 */
public class ContactPersonDeleteAction extends ActionSupport {

    private final ContactPersonService contactPersonService;
    private Long id;

    @Autowired
    public ContactPersonDeleteAction(ContactPersonService contactPersonService) {
        this.contactPersonService = contactPersonService;
    }


    public String deleteContactPerson() {
        this.contactPersonService.deleteBy(this.id);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (contactPersonService.isUsed(this.id)) {
            addActionError(getText("contactPerson.deleteError"));
        }
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
