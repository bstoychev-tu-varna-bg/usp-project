package com.tuvarna.uspproject.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class BrandsAndModelsMap {

    private Map<String, List<String>> map;

    public BrandsAndModelsMap(){
        map = initializeMap();
    }

    public Map<String, List<String>> getMap() {
        return map;
    }

    private Map<String, List<String>> initializeMap(){
        Map<String, List<String>> newMap = new HashMap<>();
        newMap.put("Mercedes-Benz",getMercedesModels());
        newMap.put("Audi",getAudiModels());
        newMap.put("BMW",getBmwModels());
        newMap.put("Renault",getRenaultModels());
        newMap.put("Peugeot",getPeugeotModels());
        newMap.put("Citroen",getCitroenModels());
        return Collections.unmodifiableMap(newMap);
    }

    private List<String> getMercedesModels(){
        return Arrays.asList("A-CLASS", "B-CLASS", "C-CLASS", "E-CLASS", "S-CLASS");
    }

    private List<String> getAudiModels(){
        return Arrays.asList("A3", "A4", "A5", "A6", "A7", "A8");
    }

    private List<String> getBmwModels(){
        return Arrays.asList("3-SERIES", "5-SERIES", "7-SERIES");
    }

    private List<String> getRenaultModels(){
        return Arrays.asList("Clio", "Megane", "Captur", "Talisman", "Kadjar");
    }

    private List<String> getPeugeotModels(){
        return Arrays.asList("206", "208", "306", "308", "406", "408");
    }

    private List<String> getCitroenModels(){
        return Arrays.asList("C3", "C4", "C5");
    }
}
