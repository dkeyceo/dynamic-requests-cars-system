package com.dkey.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dkey.criteria.CarCriteria;
import com.dkey.model.Brand_;
import com.dkey.model.Car;
import com.dkey.model.Car_;
import com.dkey.model.Model_;
import com.dkey.repository.CarsRepository;

import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class CarsService extends QueryService<Car>{
	
	@Autowired
	private CarsRepository carsRepository;

	public List<Car> findByCriteria(CarCriteria carCriteria){
		final Specification<Car> specification = createSpecification(carCriteria);
		List<Car> cars = carsRepository.findAll(specification);
		return cars;
	}
	
	private Specification<Car> createSpecification(CarCriteria carCriteria){
		Specification<Car> specification = Specification.where(null);
		
		if(carCriteria != null) {
			if(carCriteria.getVersion() != null) {
				specification = specification.and(buildStringSpecification(carCriteria.getVersion(), Car_.version));
			}
			if(carCriteria.getColor() != null) {
				specification = specification.and(buildSpecification(carCriteria.getColor(), Car_.color));
			}
			if(carCriteria.getKm() != null) {
				specification = specification.and(buildRangeSpecification(carCriteria.getKm(), Car_.km));
			}
			if(carCriteria.getChanged() != null) {
				specification = specification.and(buildSpecification(carCriteria.getChanged(), Car_.changed));
			}
			if(carCriteria.getModel() != null) {
				specification = specification.and(buildReferringEntitySpecification(carCriteria.getModel(), Car_.model, Model_.name));
			}
			if(carCriteria.getModel() != null) {
				specification = specification.and(buildSpecification(carCriteria.getModel(), 
						root -> root.join(Car_.model, JoinType.LEFT).get(Model_.name)));
			}
			if(carCriteria.getBrand() != null) {
				specification = specification.and(buildSpecification(carCriteria.getBrand(), 
						root -> root.join(Car_.model, JoinType.LEFT)
						.join(Model_.brand, JoinType.LEFT).get(Brand_.name)));
			}
			
		}
		return specification;
	}
}
