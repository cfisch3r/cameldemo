package de.agiledojo.cameldemo;

import static org.fest.assertions.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/test-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class LongToDateConverterIT {
	@Autowired
	private ConversionService conversionService;

	@Test
	public void longValueShouldBeConvertableToDate() {
		Date now = Calendar.getInstance().getTime();
		Long nowAsLong = now.getTime();
		assertThat(conversionService.convert(nowAsLong, Date.class)).isEqualTo(now);
	}
}
