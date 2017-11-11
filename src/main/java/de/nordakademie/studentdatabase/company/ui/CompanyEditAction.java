package de.nordakademie.studentdatabase.company.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.address.service.AddressService;
import de.nordakademie.studentdatabase.company.model.Company;
import de.nordakademie.studentdatabase.company.service.CompanyService;
import de.nordakademie.studentdatabase.contactPerson.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 024, 24.10.2017.
 */
public class CompanyEditAction extends ActionSupport {
    private final CompanyService companyService;
    private final ContactPersonService contactPersonService;
    private final AddressService addressService;
    private Company company;
    private Long id;
    private List<Long> contactPersonList = new ArrayList<>();
    private List<Long> addressList = new ArrayList<>();

    /**
     * Constructor
     *
     * @param companyService
     * @param contactPersonService
     * @param addressService
     */
    @Autowired
    public CompanyEditAction(CompanyService companyService, ContactPersonService contactPersonService, AddressService addressService) {
        this.companyService = companyService;
        this.contactPersonService = contactPersonService;
        this.addressService = addressService;
    }

    /**
     * finds a company by id and fills dropdown lists
     * @return
     */
    public String getForm() {
        this.company = companyService.findOne(this.id);

        fillLists(this.company);

        return SUCCESS;
    }

    /**
     * fills dropdown lists
     * @param company
     */
    private void fillLists(Company company) {
        contactPersonList = new ArrayList<>();
        contactPersonList.add(company.getContactPerson().getId());
        contactPersonList.addAll(contactPersonService.getUnusedIds());

        addressList = addressService.getAllIds();
    }

    /**
     * updates a company
     * @return
     */
    public String updateCompany() {
        companyService.update(this.company);
        return SUCCESS;
    }

    /**
     * fills dropdown lists so they are filled after validationError
     */
    @Override
    public void validate() {
        Company tempCompany = companyService.findOne(this.id);
        fillLists(tempCompany);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getContactPersonList() {
        return contactPersonList;
    }

    public void setContactPersonList(List<Long> contactPersonList) {
        this.contactPersonList = contactPersonList;
    }

    public List<Long> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Long> addressList) {
        this.addressList = addressList;
    }
}
