package com.dkey.controller;

import com.dkey.criteria.CarCriteria;
import com.dkey.dto.SearchRequestDTO;
import com.dkey.enums.Color;
import com.dkey.model.Car;
import com.dkey.service.CarsService;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarsController {
    @Autowired
    private CarsService carsService;

    @PostMapping("list")
    public ResponseEntity<List<Car>> list(@RequestBody SearchRequestDTO searchRequestDTO){
        CarCriteria carCriteria = createCriteria(searchRequestDTO);
        List<Car> list = carsService.findByCriteria(carCriteria);
        return new ResponseEntity<List<Car>>(list, HttpStatus.OK);
    }

    private CarCriteria createCriteria(SearchRequestDTO searchRequestDTO){
        CarCriteria carCriteria = new CarCriteria();

        if(searchRequestDTO != null){
            if(!StringUtils.isBlank(searchRequestDTO.getBrand())){
                StringFilter filter = new StringFilter();
                filter.setEquals(searchRequestDTO.getBrand());
                carCriteria.setBrand(filter);
            }
            if(!StringUtils.isBlank(searchRequestDTO.getModel())){
                StringFilter filter = new StringFilter();
                filter.setEquals(searchRequestDTO.getModel());
                carCriteria.setModel(filter);
            }
            if(!StringUtils.isBlank(searchRequestDTO.getVersion())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchRequestDTO.getVersion());
                carCriteria.setVersion(filter);
            }
            if(!StringUtils.isBlank(searchRequestDTO.getChanged())){
                BooleanFilter filter = new BooleanFilter();

                switch (searchRequestDTO.getChanged()){
                    case "true":
                        filter.setEquals(true);
                        break;
                    case "false":
                        filter.setEquals(false);
                        break;
                    default:
                        filter.setEquals(false);
                        break;
                }
                carCriteria.setChanged(filter);
            }
            if(!StringUtils.isBlank(searchRequestDTO.getColor())){
                CarCriteria.ColorFilter filter = new CarCriteria.ColorFilter();
                String color = searchRequestDTO.getColor().toUpperCase();
                filter.setEquals(Color.valueOf(color));
                carCriteria.setColor(filter);
            }
            if(searchRequestDTO.getKmFrom() != null || searchRequestDTO.getKmTo() != null){
                IntegerFilter filter = new IntegerFilter();
                if(searchRequestDTO.getKmFrom() != null){
                    filter.setGreaterThanOrEqual(searchRequestDTO.getKmFrom());
                    carCriteria.setKm(filter);
                }
                if(searchRequestDTO.getKmTo() != null){
                    filter.setLessThanOrEqual(searchRequestDTO.getKmTo());
                    carCriteria.setKm(filter);
                }
            }
        }
        return carCriteria;
    }
}
