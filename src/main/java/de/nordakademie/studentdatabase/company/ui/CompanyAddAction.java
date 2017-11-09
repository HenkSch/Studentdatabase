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
 * Created by U555987 on 024, 24.10.2017.
 */
public class CompanyAddAction extends ActionSupport {
    private final CompanyService companyService;
    private final ContactPersonService contactPersonService;
    private final AddressService addressService;
    private Company company;
    private List<Long> contactPersonList = new ArrayList<>();
    private List<Long> addressList = new ArrayList<>();

    @Autowired
    public CompanyAddAction(CompanyService companyService, ContactPersonService contactPersonService, AddressService addressService) {
        this.companyService = companyService;
        this.contactPersonService = contactPersonService;
        this.addressService = addressService;
    }

    public String getForm() {
        fillLists();

        return SUCCESS;
    }

    private void fillLists() {
        contactPersonList = contactPersonService.getUnusedIds();
        addressList = addressService.getAllIds();
    }

    public String createCompany() {
        companyService.create(this.company);
        return SUCCESS;
    }

    @Override
    public void validate() {
        fillLists();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
