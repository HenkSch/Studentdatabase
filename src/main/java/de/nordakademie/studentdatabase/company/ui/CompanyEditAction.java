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
public class CompanyEditAction extends ActionSupport {
    private final CompanyService companyService;
    private final ContactPersonService contactPersonService;
    private final AddressService addressService;
    private Company company;
    private Long id;
    private List<Long> contactPersonList;
    private List<Long> addressList;

    @Autowired
    public CompanyEditAction(CompanyService companyService, ContactPersonService contactPersonService, AddressService addressService) {
        this.companyService = companyService;
        this.contactPersonService = contactPersonService;
        this.addressService = addressService;
    }

    public String getAddForm() {
        contactPersonList = contactPersonService.getUnusedIds();

        addressList = addressService.getAllIds();

        return SUCCESS;
    }

    public String getEditForm() {
        this.company = companyService.findOne(this.id);

        contactPersonList = new ArrayList<>();
        contactPersonList.add(this.company.getContactPerson().getId());
        contactPersonList.addAll(contactPersonService.getUnusedIds());

        addressList = addressService.getAllIds();

        return SUCCESS;
    }

    public String createCompany() {
        companyService.create(this.company);
        return SUCCESS;
    }

    public String deleteCompany() {
        companyService.deleteBy(this.id);
        return SUCCESS;
    }

    public String updateCompany() {
        companyService.update(this.company);
        return SUCCESS;
    }

    @Override
    public void validate() {

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
