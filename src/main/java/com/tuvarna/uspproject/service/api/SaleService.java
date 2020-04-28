package com.tuvarna.uspproject.service.api;

import com.tuvarna.uspproject.model.Sale;

import java.util.Collection;
import java.util.UUID;

public interface SaleService {
    void save(Sale sale);
    Collection<Sale> findAll();
}
