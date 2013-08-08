package de.agiledojo.cameldemo;

import org.springframework.context.ApplicationEvent;

import de.agiledojo.cameldemo.businessevent.BusinessEvent;

public class ApplicationBusinessEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private BusinessEvent event;

	public ApplicationBusinessEvent(BusinessEvent event, Object source) {
		super(source);
		this.event = event;
	}

	public BusinessEvent getEvent() {
		return event;
	}

}
