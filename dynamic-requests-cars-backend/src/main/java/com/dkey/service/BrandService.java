package com.dkey.service;

import com.dkey.model.Brand;
import com.dkey.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> findAll(){
        return brandRepository.findAll();
    }
}
