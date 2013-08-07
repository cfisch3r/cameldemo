package de.agiledojo.cameldemo;

import org.springframework.context.ApplicationEvent;

import de.agiledojo.cameldemo.businessevent.LoginBusinessEvent;

public class ApplicationBusinessEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private Object event;

	public ApplicationBusinessEvent(LoginBusinessEvent event, Object source) {
		super(source);
		this.event = event;
	}

	public Object getEvent() {
		return event;
	}

}
