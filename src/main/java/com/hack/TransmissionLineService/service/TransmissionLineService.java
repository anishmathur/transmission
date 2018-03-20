package com.hack.TransmissionLineService.service;
import java.util.Set;

import com.hack.TransmissionLineService.domain.Generation;
import com.hack.TransmissionLineService.domain.TransmissionLine;

public interface TransmissionLineService {
	
	public TransmissionLine getTransmissionLine(String name);
	
	Set<Generation> getGenerationLevels(String transmissionLineName);
}
