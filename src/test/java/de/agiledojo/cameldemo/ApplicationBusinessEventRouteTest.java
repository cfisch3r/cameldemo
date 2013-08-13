package de.agiledojo.cameldemo;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.agiledojo.cameldemo.businessevent.LoginBusinessEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/test-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ApplicationBusinessEventRouteTest {

	@Autowired
	ApplicationBusinessEventPublisher eventPublisher;

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	@Test
	public void firingApplicationBusinessEventShouldBeDetectedAtRouteEndPoint() throws Exception {
		eventPublisher.fireBusinessEvent(new LoginBusinessEvent("myChannel", "dummy"));

		resultEndpoint.expectedMessageCount(1);

		resultEndpoint.assertIsSatisfied();
	}
}
