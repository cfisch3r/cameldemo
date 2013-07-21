package de.agiledojo.cameldemo;

import org.springframework.stereotype.Component;

@Component
public class CamelTestBean {

	public boolean handle(Object body) {
		return (body instanceof LoginEvent);
	}
}
