package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.model.Car;
import com.tuvarna.uspproject.model.Client;
import com.tuvarna.uspproject.model.Sale;
import com.tuvarna.uspproject.repository.SaleRepository;
import com.tuvarna.uspproject.service.api.CarService;
import com.tuvarna.uspproject.service.api.ClientService;
import com.tuvarna.uspproject.service.api.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collection;

@Service
public final class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CarService carService;

    @Override
    public void save(Sale sale) {
        sale.setDate(currentDate());
        Client client = clientService.save(sale.getClient());
        sale.setClient(client);
        Car car = carService.save(sale.getCar());
        sale.setCar(car);
        saleRepository.save(sale);
    }

    @Override
    public Collection<Sale> findAll() {
        return saleRepository.findAll();
    }

    private Date currentDate() {
        return new Date(System.currentTimeMillis());
    }
}
