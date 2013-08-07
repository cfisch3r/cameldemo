package de.agiledojo.cameldemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationBusinessEventListener implements ApplicationListener<ApplicationBusinessEvent> {

	ApplicationBusinessEvent latestEvent;

	@Override
	public void onApplicationEvent(ApplicationBusinessEvent event) {
		latestEvent = event;
	}

	public void clear() {
		latestEvent = null;
	}

	public ApplicationBusinessEvent getLatestEvent() {
		return latestEvent;
	}

}
