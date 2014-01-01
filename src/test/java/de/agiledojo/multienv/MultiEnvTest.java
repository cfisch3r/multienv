package de.agiledojo.multienv;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.agiledojo.multienv.configuration.DefaultEnvironmentConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DefaultEnvironmentConfiguration.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MultiEnvTest {

	@Autowired
	Environment env;

	@Test
	public void gettingPropertyFromEnvironmentReturnsDefaultValue() {
		final String samplePropertyName = "sample";
		final String defaultSamplePropertyValue = "default";
		assertThat(env.getProperty(samplePropertyName)).isEqualTo(defaultSamplePropertyValue);
	}
}