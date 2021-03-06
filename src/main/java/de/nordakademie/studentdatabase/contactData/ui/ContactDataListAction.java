package de.nordakademie.studentdatabase.contactData.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.contactData.model.ContactData;
import de.nordakademie.studentdatabase.contactData.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 020, 20.10.2017.
 */
public class ContactDataListAction implements Action {

    private final ContactDataService contactDataService;
    private List<ContactData> contactDataList;

    /**
     * Constructor
     *
     * @param contactDataService
     */
    @Autowired
    public ContactDataListAction(ContactDataService contactDataService) {
        this.contactDataService = contactDataService;
    }

    /**
     * finds all contactData
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        contactDataList = contactDataService.findAll();
        return SUCCESS;
    }

    public List<ContactData> getContactDataList() {
        return contactDataList;
    }
}
