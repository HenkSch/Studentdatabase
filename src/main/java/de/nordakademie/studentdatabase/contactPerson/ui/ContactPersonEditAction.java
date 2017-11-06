package de.nordakademie.studentdatabase.contactPerson.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPerson;
import de.nordakademie.studentdatabase.contactPerson.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 006, 06.11.2017.
 */
public class ContactPersonEditAction extends ActionSupport {

    private final ContactPersonService contactPersonService;
    private ContactPerson contactPerson;
    private Long id;

    @Autowired
    public ContactPersonEditAction(ContactPersonService contactPersonService) {
        this.contactPersonService = contactPersonService;
    }

    public String getAddForm() {
        return SUCCESS;
    }

    public String getEditForm() {
        contactPerson = contactPersonService.findOne(this.id);
        return SUCCESS;
    }

    public String createContactPerson() {
        contactPersonService.create(this.contactPerson);
        return SUCCESS;
    }

    public String deleteContactPerson() {
        contactPersonService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateContactPerson() {
        contactPersonService.update(this.contactPerson);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
