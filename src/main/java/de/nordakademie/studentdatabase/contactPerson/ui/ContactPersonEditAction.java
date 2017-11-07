package de.nordakademie.studentdatabase.contactPerson.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPerson;
import de.nordakademie.studentdatabase.contactPerson.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U555987 on 006, 06.11.2017.
 */
public class ContactPersonEditAction extends ActionSupport {

    private final ContactPersonService contactPersonService;
    private final ContactDataService contactDataService;
    private ContactPerson contactPerson;
    private Long id;
    private List<Long> contactDataList;

    @Autowired
    public ContactPersonEditAction(ContactPersonService contactPersonService, ContactDataService contactDataService) {
        this.contactPersonService = contactPersonService;
        this.contactDataService = contactDataService;
    }

    public String getAddForm() {
        this.contactDataList = contactDataService.getUnusedIds();
        return SUCCESS;
    }

    public String getEditForm() {
        this.contactPerson = this.contactPersonService.findOne(this.id);

        this.contactDataList = new ArrayList<>();
        this.contactDataList.add(this.contactPerson.getContactData().getId());
        this.contactDataList.addAll(contactDataService.getUnusedIds());

        return SUCCESS;
    }

    public String createContactPerson() {
        this.contactPersonService.create(this.contactPerson);
        return SUCCESS;
    }

    public String deleteContactPerson() {
        this.contactPersonService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateContactPerson() {
        this.contactPersonService.update(this.contactPerson);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }

    public ContactPerson getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getContactDataList() {
        return this.contactDataList;
    }

    public void setContactDataList(List<Long> contactDataList) {
        this.contactDataList = contactDataList;
    }
}
