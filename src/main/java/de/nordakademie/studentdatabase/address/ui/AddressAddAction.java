package de.nordakademie.studentdatabase.address.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 024, 24.10.2017.
 */
public class AddressAddAction extends ActionSupport {

    private final AddressService addressService;
    private Address address;

    @Autowired
    public AddressAddAction(AddressService addressService) {
        this.addressService = addressService;
    }

    public String getForm() {
        return SUCCESS;
    }


    public String createAddress() {
        addressService.create(this.address);
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

}