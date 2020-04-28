package com.tuvarna.uspproject.service.impl;

import com.tuvarna.uspproject.model.Brand;
import com.tuvarna.uspproject.model.Model;
import com.tuvarna.uspproject.repository.ModelRepository;
import com.tuvarna.uspproject.service.api.BrandService;
import com.tuvarna.uspproject.service.api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandService brandService;

    public Model save(Model model){
        Brand brand = brandService.save(model.getBrand());
        Model fetchedModel = modelRepository.findByName(model.getName());
        if(isExistingModel(fetchedModel)){
            return fetchedModel;
        }
        model.setBrand(brand);
        return modelRepository.save(model);
    }

    private boolean isExistingModel(Model model){
        return model != null;
    }
}
