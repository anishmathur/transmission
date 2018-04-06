package com.hack.TransmissionLineService.service;

import com.hack.TransmissionLineService.Action;
import com.hack.TransmissionLineService.Event;

public interface EventService {
	public Event getEvent();

	public void addEvent(Action action, String item);
	public void addEvent(Event event);
}
