package com.hack.TransmissionLineService.service;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.TransmissionLineService.dao.TransmissionLineRepo;
import com.hack.TransmissionLineService.domain.Generation;
import com.hack.TransmissionLineService.domain.TransmissionLine;
@Service
public class TransmissionLineServiceImpl implements TransmissionLineService {

	@Autowired
	TransmissionLineRepo  transmissionLineRepo;
	
	public Set<Generation> getGenerationLevels(String transmissionLineName){
		TransmissionLine transmissionLine = transmissionLineRepo.findByName(transmissionLineName);
		return transmissionLine.getGenerations();
	}

	@Override
	public TransmissionLine getTransmissionLine(String name) {
		return transmissionLineRepo.findByName(name);
	}
}
