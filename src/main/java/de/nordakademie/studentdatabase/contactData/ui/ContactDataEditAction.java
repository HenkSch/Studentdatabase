package de.nordakademie.studentdatabase.contactData.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 020, 20.10.2017.
 */
public class ContactDataEditAction extends ActionSupport {

    private final ContactDataService contactDataService;

    private ContactData contactData;
    private Long id;

    @Autowired
    public ContactDataEditAction(ContactDataService contactDataService) {
        this.contactDataService = contactDataService;
    }


    public String getForm() {
        contactData = contactDataService.findOne(id);
        return SUCCESS;
    }

    public String updateContactData() {
        contactDataService.update(this.contactData);
        return SUCCESS;
    }

    @Override
    public void validate() {
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
