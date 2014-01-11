package de.agiledojo.multienv;

import static org.fest.assertions.Assertions.*;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MultiEnvConfiguration.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("production")
public class ProductionProfileTest {

	private static final int DEFAULT_FIRST_DAY_OF_WEEK = 0;

	private static final String PRODUCTION_TIMEZONE_ID = "MET";

	@Autowired
	private Calendar cal;

	@Test
	public void timeZoneHasProductionProfileValue() {
		final TimeZone actualTimeZone = cal.getTimeZone();
		assertThat(actualTimeZone).isEqualTo(TimeZone.getTimeZone(PRODUCTION_TIMEZONE_ID));
	}

	@Test
	public void firstDayOFWeekHasDefaultValue() {
		final int actualFirstDayOfWeek = cal.getFirstDayOfWeek();
		assertThat(actualFirstDayOfWeek).isEqualTo(DEFAULT_FIRST_DAY_OF_WEEK);
	}
}
