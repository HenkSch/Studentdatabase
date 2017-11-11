package de.nordakademie.studentdatabase.contactData.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 020, 20.10.2017.
 */
public class ContactDataAddAction extends ActionSupport {

    private final ContactDataService contactDataService;

    private ContactData contactData;

    /**
     * Constructor
     *
     * @param contactDataService
     */
    @Autowired
    public ContactDataAddAction(ContactDataService contactDataService) {
        this.contactDataService = contactDataService;
    }

    public String getForm() {
        return SUCCESS;
    }

    /**
     * creates a contactData
     * @return
     */
    public String createContactData() {
        contactDataService.create(this.contactData);
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
}
