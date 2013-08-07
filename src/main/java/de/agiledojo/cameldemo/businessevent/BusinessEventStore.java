package de.agiledojo.cameldemo.businessevent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Stores business events in mongodb
 * 
 * @author cfisch3r
 * 
 */
public class BusinessEventStore {

	@Autowired
	private LoginBusinessEventRepository loginBusinessEventRepository;

	public void store(LoginBusinessEvent event) {
		loginBusinessEventRepository.save(event);
	}

}
