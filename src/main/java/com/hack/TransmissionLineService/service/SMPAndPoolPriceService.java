package com.hack.TransmissionLineService.service;

import java.math.BigDecimal;

import com.hack.TransmissionLineService.PoolPrice;
import com.hack.TransmissionLineService.SMP;

public interface SMPAndPoolPriceService {
	public SMP getSMP();

	public SMP setCurrentSMP(BigDecimal price);

	PoolPrice setCurrentPoolPrice(BigDecimal price);

	PoolPrice getPoolPrice();
}
