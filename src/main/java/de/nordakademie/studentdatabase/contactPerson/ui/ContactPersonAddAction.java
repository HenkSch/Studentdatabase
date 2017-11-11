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
public class ContactPersonAddAction extends ActionSupport {

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
    public ContactPersonAddAction(ContactPersonService contactPersonService, ContactDataService contactDataService) {
        this.contactPersonService = contactPersonService;
        this.contactDataService = contactDataService;
    }

    /**
     * fills dropdown lists
     * @return
     */
    public String getForm() {
        fillLists();
        return SUCCESS;
    }

    /**
     * fills dropdown lists
     */
    private void fillLists() {
        this.contactDataList = contactDataService.getUnusedIds();
    }

    /**
     * creates a contactPerson
     * @return
     */
    public String createContactPerson() {
        this.contactPersonService.create(this.contactPerson);
        return SUCCESS;
    }

    /**
     * fills dropdown lists so they are filled after validationError
     */
    @Override
    public void validate() {
        fillLists();
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
