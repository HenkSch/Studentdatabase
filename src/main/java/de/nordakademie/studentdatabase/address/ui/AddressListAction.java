package de.nordakademie.studentdatabase.address.ui;

import com.opensymphony.xwork2.Action;
import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 024, 24.10.2017.
 */
public class AddressListAction implements Action {

    private final AddressService addressService;
    private List<Address> addressList;

    @Autowired
    public AddressListAction(AddressService addressService) {
        this.addressService = addressService;
    }


    @Override
    public String execute() throws Exception {
        addressList = addressService.findAll();
        return SUCCESS;
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
