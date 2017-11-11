package de.nordakademie.studentdatabase.contactPerson.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPerson;
import de.nordakademie.studentdatabase.contactPerson.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 006, 06.11.2017.
 */
public class ContactPersonEditAction extends ActionSupport {

    private final ContactPersonService contactPersonService;
    private final ContactDataService contactDataService;
    private ContactPerson contactPerson;
    private Long id;
    private List<Long> contactDataList = new ArrayList<>();

    /**
     * Constructor
     *
     * @param contactPersonService
     * @param contactDataService
     */
    @Autowired
    public ContactPersonEditAction(ContactPersonService contactPersonService, ContactDataService contactDataService) {
        this.contactPersonService = contactPersonService;
        this.contactDataService = contactDataService;
    }

    /**
     * finds a contactPerson by id and fills dropdown lists
     * @return
     */
    public String getForm() {
        this.contactPerson = this.contactPersonService.findOne(this.id);

        fillLists(this.contactPerson);

        return SUCCESS;
    }

    /**
     * fills dropdown lists
     * @param contactPerson
     */
    private void fillLists(ContactPerson contactPerson) {
        this.contactDataList = new ArrayList<>();
        this.contactDataList.add(contactPerson.getContactData().getId());
        this.contactDataList.addAll(contactDataService.getUnusedIds());
    }

    /**
     * updates a contactPerson
     * @return
     */
    public String updateContactPerson() {
        this.contactPersonService.update(this.contactPerson);
        return SUCCESS;
    }

    /**
     * fills dropdown lists so they are filled after validationError
     */
    @Override
    public void validate() {
        ContactPerson tempContactPerson = this.contactPersonService.findOne(this.id);
        fillLists(tempContactPerson);
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
