package com.example.tp1.api;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tp1.entity.Products;
import com.example.tp1.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

    @Autowired
    private ProductService productsService;

    // localhost:8080/api/products
    @GetMapping("")
    public ResponseEntity<?> doGetAll() {
        List<Products> products = productsService.findAll();
        return ResponseEntity.ok(products);
    }

    // localhost:8080/api/products/slug/{....}
    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> doGetBySlug(@PathVariable("slug") String slug) {
        Products product = productsService.findBySlug(slug);
        if (ObjectUtils.isEmpty(product)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400
        }
        return ResponseEntity.ok(product);
    }
    // localhost:8080/api/products/find?id={...}
    @GetMapping("/find")
    public ResponseEntity<?> doGetById(@RequestParam ("id") Long id){
        Products product = productsService.findById(id);
        if (ObjectUtils.isEmpty(product)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(product);
    }
//    @GetMapping("/find")
//    public ResponseEntity<?> doGetById(@RequestParam ("id") Long id){
//        Optional<Products> product = productsService.findById(id);
//        if (ObjectUtils.isEmpty(product)){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(product);
//    }
}

