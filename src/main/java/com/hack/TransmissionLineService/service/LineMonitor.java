package com.hack.TransmissionLineService.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hack.TransmissionLineService.Action;
import com.hack.TransmissionLineService.Event;
import com.hack.TransmissionLineService.domain.TransmissionLine;


@Component
@Transactional(readOnly=true)
public class LineMonitor {

    private static final Logger log = LoggerFactory.getLogger(LineMonitor.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    TransmissionLineService transmissionLineService;
    
    @Autowired
    Event event;

    //@Scheduled(fixedRate = 20000)
    public void checkLineCapacity() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        transmissionLineService.getAllTransmissionLines().stream().forEach(line -> monitor(line));
    }

	private void monitor(TransmissionLine line) {
		int capacity = line.getCapacity().intValue();
		int totalGen = getTotalGenForLine(line);
		log.info("totalGen={}, capacity={}",totalGen, capacity);
		if(totalGen > capacity){			
			event.setAction(Action.RECOMMEND_CONSTRAINT);
			event.setItem(line.getName());
			log.info("Apply constraint, event={}, item={}", event.getAction(), event.getItem());
		}
	}

	private int getTotalGenForLine(TransmissionLine line) {		
		return line.getGenerations().stream().mapToInt(gen -> gen.getGenerationLevel().intValue()).sum(); 
	}
}
