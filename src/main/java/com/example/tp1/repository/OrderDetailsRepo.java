package com.example.tp1.repository;

import com.example.tp1.dto.CartDetailDto;
import com.example.tp1.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO order_details(orderId, productId, price, quantity)"
            + " VALUES (:#{#dto.orderId}, :#{#dto.productId}, :#{#dto.price}, :#{#dto.quantity})",
            nativeQuery = true)
    void insert(@Param("dto") CartDetailDto cartDetailDto);
}
