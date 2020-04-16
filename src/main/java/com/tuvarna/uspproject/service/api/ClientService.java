package com.tuvarna.uspproject.service.api;

import com.tuvarna.uspproject.model.Client;

import java.util.Collection;
import java.util.UUID;

public interface ClientService {
    void save(Client client);
    void update(Client client);
    Client findById(UUID id);
    Collection<Client> findAll();
}
