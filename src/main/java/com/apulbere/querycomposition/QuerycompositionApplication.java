package com.apulbere.querycomposition;

import com.apulbere.querycomposition.domain.Cost;
import com.apulbere.querycomposition.domain.CostRepository;
import com.apulbere.querycomposition.domain.PriceQueryRequest;
import com.apulbere.querycomposition.domain.PriceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class QuerycompositionApplication implements CommandLineRunner {

	@Autowired
	private CostRepository costRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuerycompositionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var p1 = UUID.randomUUID();
		var c1 = new Cost(UUID.randomUUID(), new BigDecimal(18), new BigDecimal(89), PriceType.RETAIL, p1);
		var c2 = new Cost(UUID.randomUUID(), new BigDecimal(22), new BigDecimal(32), PriceType.WHOLESALE, p1);

		Stream.of(c1, c2).forEach(costRepository::save);

		System.out.println(costRepository.find(p1));
		//[TotalCostGroup(super=TotalCost(price1=18.00, price2=89.00), type=RETAIL),
		// TotalCostGroup(super=TotalCost(price1=22.00, price2=32.00), type=WHOLESALE)]

		System.out.println(costRepository.find(new PriceQueryRequest(new BigDecimal(18), new BigDecimal(89))));
	}
}
