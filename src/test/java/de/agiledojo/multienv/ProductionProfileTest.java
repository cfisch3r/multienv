package de.agiledojo.multienv;

import static org.fest.assertions.Assertions.*;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.agiledojo.multienv.configuration.MultiEnvConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MultiEnvConfiguration.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductionProfileTest {
	private static final int FIRST_DAY_OF_WEEK_IN_PROPERTY_FILE = 0;

	private static final String TIMEZONE_ID_IN_PROPERTY_FILE = "CET";

	@Autowired
	Calendar cal;

	@Test
	public void timeZoneHasValueFromPropertyFile() {
		final TimeZone timeZoneFromPropertyFile = TimeZone.getTimeZone(TIMEZONE_ID_IN_PROPERTY_FILE);
		final TimeZone actualTimeZone = cal.getTimeZone();
		assertThat(actualTimeZone).isEqualTo(timeZoneFromPropertyFile);
	}

	@Test
	public void firstDayOFWeekHasValueFromPropertyFile() {
		final int firstDayOfWeekFromPropertyFile = FIRST_DAY_OF_WEEK_IN_PROPERTY_FILE;
		final int actualFirstDayOfWeek = cal.getFirstDayOfWeek();
		assertThat(actualFirstDayOfWeek).isEqualTo(firstDayOfWeekFromPropertyFile);
	}

}
