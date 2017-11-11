package de.nordakademie.studentdatabase.address.service;

import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.address.model.AddressRepository;
import de.nordakademie.studentdatabase.company.model.CompanyRepository;
import de.nordakademie.studentdatabase.student.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Henk Schuhmann, Sarah Bruhn on 023, 23.10.2017.
 */
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final StudentRepository studentRepository;
    private Long id;

    /**
     * Constructor
     *
     * @param addressRepository
     * @param companyRepository
     * @param studentRepository
     */
    @Autowired
    public AddressService(AddressRepository addressRepository, CompanyRepository companyRepository, StudentRepository studentRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * returns all addressIds
     * @return
     */
    @Transactional
    public List<Long> getAllIds() {
        return addressRepository.getAllIds();
    }

    /**
     * returns all addresses
     * @return
     */
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    /**
     * finds one address by addressId
     * @param addressId
     * @return
     */
    @Transactional(readOnly = true)
    public Address findOne(final Long addressId) {
        return addressRepository.findOne(addressId);
    }

    /**
     * creates an address
     * @param address
     */
    @Transactional
    public void create(final Address address) {
        addressRepository.create(address);
    }

    /**
     * updates an address
     * @param address
     */
    @Transactional
    public void update(final Address address) {
        addressRepository.update(address);
    }

    /**
     * deletes an address by id
     * @param addressId
     */
    @Transactional
    public void deleteBy(final Long addressId) {
        final Address address = addressRepository.findOne(addressId);
        if (address != null) {
            addressRepository.delete(address);
        }
    }

    /**
     * checks if address with addressId is used or not
     * @param addressId
     * @return
     */
    @Transactional
    public boolean isUsed(Long addressId) {
        Boolean isAddressUsedInStudent = studentRepository.isAddressUsed(addressId);
        Boolean isAddressUsedInCompany = companyRepository.isAddressUsed(addressId);
        return (isAddressUsedInStudent || isAddressUsedInCompany);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
