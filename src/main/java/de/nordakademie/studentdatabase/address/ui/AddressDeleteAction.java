package de.nordakademie.studentdatabase.address.ui;

import com.opensymphony.xwork2.ActionSupport;
import de.nordakademie.studentdatabase.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 024, 24.10.2017.
 */
public class AddressDeleteAction extends ActionSupport {

    private final AddressService addressService;
    private Long id;

    /**
     * Constructor
     *
     * @param addressService
     */
    @Autowired
    public AddressDeleteAction(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * deletes an address by id
     * @return
     */
    public String deleteAddress() {
        addressService.deleteBy(this.id);
        return SUCCESS;
    }

    /**
     * adds Error if address with id is used
     */
    @Override
    public void validate() {
        if (addressService.isUsed(this.id)) {
            addActionError(getText("address.deleteError"));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
