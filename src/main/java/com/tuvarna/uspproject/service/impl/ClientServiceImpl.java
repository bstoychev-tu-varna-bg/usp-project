package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.model.Address;
import com.tuvarna.uspproject.model.Client;
import com.tuvarna.uspproject.repository.ClientRepository;
import com.tuvarna.uspproject.service.api.AddressService;
import com.tuvarna.uspproject.service.api.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public final class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressService addressService;

    @Override
    public Client save(Client client) {
        Address address = addressService.save(client.getAddress());
        client.setAddress(address);
        clientRepository.save(client);
        return client;
    }

    @Override
    public Collection<Client> findAll() {
        return clientRepository.findAll();
    }

    private boolean isExistingClient(Client client) {
        return clientRepository.existsById(client.getId());
    }
}
