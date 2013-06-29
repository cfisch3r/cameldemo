package de.agiledojo.cameldemo;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/test-context.xml")
public class LogEventReaderIT {

	@Autowired
	private LogEventReader sut;

	@Test
	public void readingFromLogfilesReturnsListOfMessages() {
		assertThat(sut.getMessages()).isNotEmpty();
	}
}
