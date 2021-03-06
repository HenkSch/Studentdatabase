package de.nordakademie.studentdatabase.contactPerson.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.contactPerson.model.ContactPerson;
import de.nordakademie.studentdatabase.contactPerson.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 006, 06.11.2017.
 */
public class ContactPersonListAction implements Action {

    private final ContactPersonService contactPersonService;
    private List<ContactPerson> contactPersonList;

    /**
     * Constructor
     *
     * @param contactPersonService
     */
    @Autowired
    public ContactPersonListAction(ContactPersonService contactPersonService) {
        this.contactPersonService = contactPersonService;
    }

    /**
     * finds all contactPersons
     * @return
     */
    @Override
    public String execute() {
        contactPersonList = contactPersonService.findAll();
        return SUCCESS;
    }

    public List<ContactPerson> getContactPersonList() {
        return contactPersonList;
    }
}
