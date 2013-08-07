package de.agiledojo.cameldemo;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/test-context.xml")
public class LoginEventPublisherTest {

	@Autowired
	LoginEventPublisher sut;

	@Autowired
	TestLoginEventListener eventListener;

	@Test
	public void onEventListenerIsCalledWhenEventIsPublished() throws InterruptedException {
		eventListener.clear();
		sut.fireLoginEvent();
		assertThat(eventListener.getLatestEvent()).isNotNull();
	}

}
