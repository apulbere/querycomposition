package com.apulbere.querycomposition.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CostRepository extends JpaRepository<Cost, UUID> {

    /*
    @Query("SELECT new com.apulbere.querycomposition.domain.TotalCostGroup(c.type," +
            "com.apulbere.querycomposition.domain.TotalCost(" +
                "SUM(c.price1), SUM(c.price2))) from Cost c " +
            " WHERE c.productId = :pid GROUP BY c.type ")
    List<TotalCostGroup> find(@Param("pid") UUID productId);
     */

    @Query("SELECT new com.apulbere.querycomposition.domain.TotalCostGroup(c.type," +
            "SUM(c.price1), SUM(c.price2)) from Cost c " +
            " WHERE c.productId = :pid GROUP BY c.type ")
    List<TotalCostGroup> find(@Param("pid") UUID productId);


    @Query("Select s from Cost s where s.price1 = :#{#req.price1} and s.price2 = :#{#req.price2}")
    List<Cost> find(PriceQueryRequest req);

    @Query(value = "Select s.* from cost s where s.price1 = :#{#req.price1} and s.price2 = :#{#req.price2}", nativeQuery = true)
    List<Cost> findNative(PriceQueryRequest req);
}
