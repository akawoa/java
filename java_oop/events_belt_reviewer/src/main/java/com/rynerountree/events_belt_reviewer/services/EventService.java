package com.rynerountree.events_belt_reviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rynerountree.events_belt_reviewer.models.Event;
import com.rynerountree.events_belt_reviewer.repositories.EventRepository;




@Service
public class EventService {

	@Autowired
	private EventRepository eventRepo;
	
	
	
	// --------------------  CRUD FOR EVENTS ------------------//
	//finds all events
	public List<Event> allEvents(){
		return eventRepo.findAll();
	}
	//creates an Event
	public Event saveEvent(Event e) {
		return eventRepo.save(e);
	}
	// retrieves an event by their id
	public Event findEvent(Long id) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
	}
	//deletes an event by their id
	public void deleteEvent(Long event_id) {
		eventRepo.deleteById(event_id);
	}
	
    // edits a language
    public Event updateEvent(Event e) {
    	return eventRepo.save(e);
    }
	
	// --------------------  CRUD FOR EVENTS ------------------//
	
	
	
	
	
	
}
