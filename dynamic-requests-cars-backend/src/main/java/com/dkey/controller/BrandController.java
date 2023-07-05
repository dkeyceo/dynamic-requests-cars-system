package com.dkey.controller;

import com.dkey.model.Brand;
import com.dkey.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/list")
    public ResponseEntity<List<Brand>> list(){
        List<Brand> list = brandService.findAll();
        return new ResponseEntity<List<Brand>>(list, HttpStatus.OK);
    }

}
