package de.agiledojo.cameldemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestLoginEventListener implements ApplicationListener<LoginEvent> {

	LoginEvent latestEvent;

	@Override
	public void onApplicationEvent(LoginEvent event) {
		latestEvent = event;
	}

	public void clear() {
		latestEvent = null;
	}

	public LoginEvent getLatestEvent() {
		return latestEvent;
	}

}
