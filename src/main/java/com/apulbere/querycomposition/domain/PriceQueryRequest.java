package com.apulbere.querycomposition.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class PriceQueryRequest {
    BigDecimal price1;
    BigDecimal price2;
}
