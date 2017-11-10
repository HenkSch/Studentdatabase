package de.nordakademie.studentdatabase.address.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann on 024, 24.10.2017.
 */
public class AddressEditAction extends ActionSupport {

    private final AddressService addressService;
    private Address address;
    private Long id;

    @Autowired
    public AddressEditAction(AddressService addressService) {
        this.addressService = addressService;
    }

    public String getForm() {
        address = addressService.findOne(this.id);
        return SUCCESS;
    }

    public String updateAddress() {
        addressService.update(this.address);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
