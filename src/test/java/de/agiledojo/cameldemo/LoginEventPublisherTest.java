package de.agiledojo.cameldemo;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.agiledojo.cameldemo.businessevent.BusinessEvent;
import de.agiledojo.cameldemo.businessevent.LoginBusinessEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/test-context.xml")
public class LoginEventPublisherTest {

	@Autowired
	ApplicationBusinessEventPublisher sut;

	@Autowired
	TestApplicationBusinessEventListener eventListener;

	@Test
	public void onEventListenerIsCalledWhenEventIsPublished() throws InterruptedException {
		eventListener.clear();
		BusinessEvent event = new LoginBusinessEvent("myChannel", "test");
		sut.fireBusinessEvent(event);
		assertThat(eventListener.getLatestEvent()).isNotNull();
	}

}
