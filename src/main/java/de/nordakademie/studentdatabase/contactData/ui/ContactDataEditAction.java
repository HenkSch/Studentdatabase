package de.nordakademie.studentdatabase.contactData.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 020, 20.10.2017.
 */
public class ContactDataEditAction extends ActionSupport {

    protected final ContactDataService contactDataService;

    private ContactData contactData;
    private Long id;

    @Autowired
    public ContactDataEditAction(ContactDataService contactDataService) {
        this.contactDataService = contactDataService;
    }

    public String getAddForm() {
        return SUCCESS;
    }

    public String getEditForm() {
        contactData = contactDataService.findOne(id);
        return SUCCESS;
    }

    public String saveContactData() {
        contactDataService.save(this.contactData);
        return SUCCESS;
    }

    public String deleteContactData() {
        contactDataService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateContactData() {
        System.out.println(this.contactData);
        System.out.println(contactData.getId());
        System.out.println(id);
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
