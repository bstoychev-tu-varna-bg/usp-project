package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.model.Address;
import com.tuvarna.uspproject.repository.AddressRepository;
import com.tuvarna.uspproject.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        addressRepository.save(address);
        return address;
    }
}
