package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.model.Brand;
import com.tuvarna.uspproject.repository.BrandRepository;
import com.tuvarna.uspproject.service.api.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand save(Brand brand){
        Brand fetchedBrand = brandRepository.findByName(brand.getName());
        if(isExistingBrand(fetchedBrand)){
            return fetchedBrand;
        }
        return brandRepository.save(brand);
    }

    private boolean isExistingBrand(Brand brand){
        return brand != null;
    }
}
