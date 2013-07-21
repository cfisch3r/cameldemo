package de.agiledojo.cameldemo;

import org.apache.camel.Handler;
import org.springframework.stereotype.Component;

@Component
public class CamelTestBean {

	@Handler
	public boolean handle(Object body) {
		return (body instanceof LoginEvent);
	}
}
