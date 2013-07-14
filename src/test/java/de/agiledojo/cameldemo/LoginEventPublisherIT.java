package de.agiledojo.cameldemo;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/test-context.xml")
@Component
public class LoginEventPublisherIT implements ApplicationListener<LoginEvent> {

	@Autowired
	LoginEventPublisher sut;

	boolean isEventThrown = false;

	@Before
	public void clearNotificationFlag() {
		isEventThrown = false;
	}

	@Test
	public void onEventListenerIsCalledWhenEventIsPublished() {
		sut.fireLoginEvent();
	}

	@Override
	public void onApplicationEvent(LoginEvent arg0) {
		isEventThrown = true;
		assertThat(isEventThrown).isTrue();
	}
}
