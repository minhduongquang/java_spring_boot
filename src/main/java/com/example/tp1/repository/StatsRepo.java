package com.example.tp1.repository;

import com.example.tp1.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface StatsRepo extends JpaRepository<Orders, Long> {

//    @Query(value = "{CALL sp_getTotalPricePerMonth(:month, :year)}", nativeQuery = true)
//    String getTotalPricePerMonth(@Param("month") String month, @Param("year") String year);
      @Query(value = "{CALL sp_getTotalPricePerMonth(:month, :year)}", nativeQuery = true)
      String getTotalPricePerMonth(@Param("month") String month, @Param("year") String year);
}
