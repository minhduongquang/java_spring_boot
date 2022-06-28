package com.example.tp1.repository;


import com.example.tp1.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
    List<Products> findByProductType_Id(Long typeId);

    Products findBySlug(String slug);

    @Query(value = "select * from product where isDeleted = 0 and quantity > 0", nativeQuery = true)
    List<Products> findAllAvailable();

    List<Products> findByIsDeletedAndQuantityGreaterThan(Boolean isDeleted, Integer quantity);
}
