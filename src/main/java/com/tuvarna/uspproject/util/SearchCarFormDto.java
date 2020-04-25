package com.tuvarna.uspproject.util;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class SearchCarFormDto {

    private List<String> criteria;

    public List<String> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<String> criteria) {
        this.criteria = criteria;
    }

    public List<String> getProcessedCriteria() {
        processCriteria();
        return criteria;
    }

    private void processCriteria(){
        criteria.removeIf(Objects::isNull);
        for(Iterator<String> it = criteria.iterator(); it.hasNext();){
            String criterion = it.next();
            String[] values = criterion.split(":");
            if(values.length == 1){
                it.remove();
            }
        }
    }
}
