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
public class DefaultConfigurationTest {

	@Autowired
	Calendar cal;

	@Test
	public void timeZoneHasValueFromPropertyFile() {
		TimeZone timeZoneFromPropertyFile = TimeZone.getTimeZone("CET");
		TimeZone actualTimeZone = cal.getTimeZone();
		assertThat(actualTimeZone).isEqualTo(timeZoneFromPropertyFile);
	}
}
