package de.agiledojo.multienv;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.agiledojo.multienv.configuration.MultiEnvConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MultiEnvConfiguration.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("production")
public class MultiEnvTest {

	private static final String PRODUCTION_PROPERTY_VALUE = "production";

	private static final String GENERAL_PROPERTY_VALUE = "default";

	@Autowired
	SampleBean bean;

	@Test
	public void sampleBeanGeneralValueHasValueFromPropertyFileDefinedInGeneralApplicationContext() {
		final String actualValue = bean.getGeneralValue();
		assertThat(actualValue).isEqualTo(GENERAL_PROPERTY_VALUE);
	}

	@Test
	public void sampleBeanEnvironmentSpecificValueHasValueFromPropertySourceOfProductionConfiguration() {
		final String actualValue = bean.getEnvironmentSpecificValue();
		assertThat(actualValue).isEqualTo(PRODUCTION_PROPERTY_VALUE);
	}
}