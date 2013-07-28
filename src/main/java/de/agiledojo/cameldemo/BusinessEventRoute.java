package de.agiledojo.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;

/**
 * Routes Business events to destination
 * 
 * @author cfisch3r
 * 
 */
public class BusinessEventRoute extends RouteBuilder {

	private @Value("${businessevent.endpoint}")
	String endpoint;

	@Override
	public void configure() throws Exception {
		from("spring-event://default").filter(method(EventFilter.class)).to(endpoint);
	}

}
