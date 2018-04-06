package com.hack.TransmissionLineService;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class PoolPrice {
	
	private BigDecimal currentpoolPrice;

	public BigDecimal getCurrentpoolPrice() {
		return currentpoolPrice;
	}

	public void setCurrentpoolPrice(BigDecimal currentpoolPrice) {
		this.currentpoolPrice = currentpoolPrice;
	}

	
}
