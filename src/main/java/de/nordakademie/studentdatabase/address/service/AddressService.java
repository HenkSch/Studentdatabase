package de.nordakademie.studentdatabase.address.service;

import de.nordakademie.studentdatabase.address.model.Address;
import de.nordakademie.studentdatabase.address.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by U555987 on 023, 23.10.2017.
 */
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private Long id;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
