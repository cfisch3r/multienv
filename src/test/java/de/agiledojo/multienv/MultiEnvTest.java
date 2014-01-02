package de.agiledojo.multienv;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	@Autowired
	Environment env;

	@Autowired
	SampleBean bean;

	@Test
	public void gettingPropertyFromEnvironmentReturnsDefaultValue() {
		final String samplePropertyName = "sample";
		final String defaultSamplePropertyValue = "production";
		assertThat(env.getProperty(samplePropertyName)).isEqualTo(defaultSamplePropertyValue);
	}

	@Test
	public void gettingDefaultPropertyWhenNotSpecifiedInProfile() {
		final String samplePropertyName = "sample2";
		final String defaultSamplePropertyValue = "default";
		assertThat(env.getProperty(samplePropertyName)).isEqualTo(defaultSamplePropertyValue);
	}

	@Test
	public void sampleBeanPropertyHasDefaultValueWhenPropertyIsNotDeclaredInProductionProfile() {
		final String actualValue = bean.getGeneralValue();
		assertThat(actualValue).isEqualTo("default");
	}

	@Test
	public void sampleBeanPropertyHasProductionValueWhenPropertyIsDeclaredInProductionProfile() {
		final String actualValue = bean.getEnvironmentSpecificValue();
		assertThat(actualValue).isEqualTo("production");
	}
}