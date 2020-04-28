package com.tuvarna.uspproject.service.api;

import com.tuvarna.uspproject.model.Client;

import java.util.Collection;
import java.util.UUID;

public interface ClientService {
    Client save(Client client);
    Collection<Client> findAll();
}
