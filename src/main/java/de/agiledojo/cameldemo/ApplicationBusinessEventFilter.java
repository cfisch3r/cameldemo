package de.agiledojo.cameldemo;

import org.springframework.stereotype.Component;

/**
 * Filters ApplicationBusinessEvents
 * 
 * @author cfisch3r
 * 
 */
@Component
public class ApplicationBusinessEventFilter {

	public boolean handle(Object body) {
		return (body instanceof ApplicationBusinessEvent);
	}
}
