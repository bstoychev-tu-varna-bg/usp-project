package com.tuvarna.uspproject.repository.custom;

import com.tuvarna.uspproject.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class CarRepositoryCustomImpl implements CarRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Car> findByCriteria(Set<String> criteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query = criteriaBuilder.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);

        List<Predicate> predicates = new ArrayList<>();
        criteria.forEach(criterion -> {
            String criterionName = criterion.split(":")[0];
            String criterionValue = criterion.split(":")[1];
            Path<String> criterionNamePath = car.get(criterionName);
            predicates.add(criteriaBuilder.equal(criterionNamePath, criterionValue));
        });

        query.select(car).where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query).getResultList();
    }
}
