package de.agiledojo.cameldemo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class LoginEventPublisher implements ApplicationEventPublisherAware {

	ApplicationEventPublisher publisher;

	public void fireLoginEvent() {
		publisher.publishEvent(new LoginEvent(this));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}

}
