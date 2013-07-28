package de.agiledojo.cameldemo;

import org.apache.camel.builder.RouteBuilder;

/**
 * Routes Business events to destination
 * 
 * @author cfisch3r
 * 
 */
public class BusinessEventRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("spring-event://default").filter(method(EventFilter.class)).to("mock:result");
	}

}
