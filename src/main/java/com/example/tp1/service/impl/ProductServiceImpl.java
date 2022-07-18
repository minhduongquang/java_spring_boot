package com.example.tp1.service.impl;

import com.example.tp1.entity.Products;
import com.example.tp1.repository.ProductRepo;
import com.example.tp1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    @Override
    public List<Products> findAll() {
//        return repo.findAllAvailable();
        return repo.findByIsDeletedAndQuantityGreaterThan(Boolean.FALSE, 0);
    }

    @Override
    public Products findById(Long id){
        Optional<Products> result =  repo.findById(id);
        //return result.isPresent() ? result.get() : null ;
        return result.isPresent() ? result.get() : null ;

    }
//    public Optional<Products> findById(Long id){
//        Optional<Products> result =  repo.findById(id);
//        //return result.isPresent() ? result.get() : null ;
//        return result.isPresent() ? Optional.of(result.get()) : null ;
//
//    }

    @Override
    public Products findBySlug(String slug){
        return repo.findBySlug(slug);
    }

}
