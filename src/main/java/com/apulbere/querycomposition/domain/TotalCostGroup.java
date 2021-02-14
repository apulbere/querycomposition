package com.apulbere.querycomposition.domain;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class TotalCostGroup extends TotalCost {

    private PriceType type;

    public TotalCostGroup(PriceType type, BigDecimal price1, BigDecimal price2) {
        super(price1, price2);
        this.type = type;
    }
}
