package de.agiledojo.cameldemo.businessevent;

import static org.fest.assertions.Assertions.*;

import java.util.List;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/systemtest-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BusinessEventStoreRouteIT {

	@Produce(uri = "direct:storeBusinessEvent")
	protected ProducerTemplate template;

	@Autowired
	protected MongoTemplate eventDB;

	@Autowired
	protected LoginBusinessEventRepository loginBusinessEventRepository;

	@Before
	public void clearCollection() {
		if (eventDB.collectionExists(LoginBusinessEvent.class)) {
			eventDB.dropCollection(LoginBusinessEvent.class);
		}
	}

	@Test
	public void newEventShouldBeStoredInDatase() {
		LoginBusinessEvent event = new LoginBusinessEvent("myChannel", "Dummy");
		template.sendBody(event);
		List<LoginBusinessEvent> events = loginBusinessEventRepository.findAll();
		assertThat(events.size()).isEqualTo(1);
		assertThat(events.get(0)).isEqualTo(event);
	}

}
