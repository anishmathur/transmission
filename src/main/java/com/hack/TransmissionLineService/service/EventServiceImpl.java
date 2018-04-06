package com.hack.TransmissionLineService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.TransmissionLineService.Action;
import com.hack.TransmissionLineService.Event;
@Service
public class EventServiceImpl implements EventService{

	@Autowired
	Event event;
	
	@Override
	public Event getEvent() {
		Event newEvent = null;
		if(event.getAction()!=null){
			newEvent = new Event(event.getAction(),event.getItem() );
			event.setAction(Action.NO_PENDING_ACTION);
			event.setItem("TestLine223");
		}else{
			newEvent = new Event(Action.NO_PENDING_ACTION,"TestLine22");
		}
		return newEvent;
	}

	@Override
	public void addEvent(Action action, String item) {
		event.setAction(action);
		event.setItem(item);
	}
	
	@Override
	public void addEvent(Event event) {
		this.event = event;
	}

}
