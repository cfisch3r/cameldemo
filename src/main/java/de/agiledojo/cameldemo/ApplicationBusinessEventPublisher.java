package de.agiledojo.cameldemo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import de.agiledojo.cameldemo.businessevent.LoginBusinessEvent;

@Component
public class ApplicationBusinessEventPublisher implements ApplicationEventPublisherAware {

	ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}

	public void fireBusinessEvent(LoginBusinessEvent event) {
		ApplicationBusinessEvent applicationEvent = new ApplicationBusinessEvent(event, this);
		publisher.publishEvent(applicationEvent);
	}

}
