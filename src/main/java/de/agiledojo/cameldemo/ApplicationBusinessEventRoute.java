package de.agiledojo.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;

/**
 * Camel route, which listens for Spring application events, filters for
 * ApplicationBusinessEvents and forwards to configured destination
 * 
 * @author cfisch3r
 * 
 */
public class ApplicationBusinessEventRoute extends RouteBuilder {

	private @Value("${applicationbusinessevent.endpoint}")
	String endpoint;

	@Override
	public void configure() throws Exception {
		from("spring-event://default").filter(method(ApplicationBusinessEventFilter.class)).to(endpoint);
	}

}
