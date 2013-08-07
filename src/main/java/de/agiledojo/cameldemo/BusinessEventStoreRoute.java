package de.agiledojo.cameldemo;

import org.apache.camel.builder.RouteBuilder;

/**
 * Routes Business events to mongo db store
 * 
 * @author cfisch3r
 * 
 */
public class BusinessEventStoreRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:storeBusinessEvent").bean(BusinessEventStore.class);
	}

}
