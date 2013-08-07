package de.agiledojo.cameldemo;

import org.springframework.stereotype.Component;

@Component
public class EventFilter {

	public boolean handle(Object body) {
		return (body instanceof ApplicationBusinessEvent);
	}
}
