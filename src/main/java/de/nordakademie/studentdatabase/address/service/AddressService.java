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
 * Created by Henk Schuhmann on 023, 23.10.2017.
 */
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final StudentRepository studentRepository;
    private Long id;

    @Autowired
    public AddressService(AddressRepository addressRepository, CompanyRepository companyRepository, StudentRepository studentRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public List<Long> getAllIds() {
        return addressRepository.getAllIds();
    }

    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Address findOne(final Long addressId) {
        return addressRepository.findOne(addressId);
    }

    @Transactional
    public void create(final Address address) {
        addressRepository.create(address);
    }

    @Transactional
    public void update(final Address address) {
        addressRepository.update(address);
    }

    @Transactional
    public void deleteBy(final Long addressId) {
        final Address address = addressRepository.findOne(addressId);
        if (address != null) {
            addressRepository.delete(address);
        }
    }

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
