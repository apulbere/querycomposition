package com.apulbere.querycomposition.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TotalCost {

    private BigDecimal price1;
    private BigDecimal price2;
}
