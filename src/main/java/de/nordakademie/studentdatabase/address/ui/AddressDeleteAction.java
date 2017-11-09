package de.nordakademie.studentdatabase.address.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by U555987 on 024, 24.10.2017.
 */
public class AddressDeleteAction extends ActionSupport {

    private final AddressService addressService;
    private Long id;

    @Autowired
    public AddressDeleteAction(AddressService addressService) {
        this.addressService = addressService;
    }

    public String deleteAddress() {
        addressService.deleteBy(this.id);
        return SUCCESS;
    }


    @Override
    public void validate() {
        if (addressService.isUsed(this.id)) {
            addActionError("Cannot delete used address.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
