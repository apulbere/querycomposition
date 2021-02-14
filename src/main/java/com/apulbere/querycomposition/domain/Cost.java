package com.apulbere.querycomposition.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cost")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cost {

    @Id
    private UUID id;
    private BigDecimal price1;
    private BigDecimal price2;
    private PriceType type;
    private UUID productId;
}
