package de.agiledojo.cameldemo;

import org.springframework.context.ApplicationEvent;

public class LoginEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
