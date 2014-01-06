package de.agiledojo.multienv.configuration;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import de.agiledojo.multienv.SampleBean;

/**
 * Base Application configuration
 * 
 */
@Configuration
@PropertySource("classpath:/de/agiledojo/multienv/conf/default.properties")
@Import(ProductionEnvironmentConfiguration.class)
public class MultiEnvConfiguration {

	@Value("${general}")
	private String generalValue;

	@Value("${specific}")
	private String environmentSpecificValue;

	@Value("${timezone.id}")
	private String timeZoneID;

	@Value("${firstDayOfWeek}")
	private int firstDayOfWeek;

	@Bean
	@Autowired
	public SampleBean createSampleBean() {
		return new SampleBean(generalValue, environmentSpecificValue);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Calendar configuredCalendar() {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(timeZoneID));
		cal.setFirstDayOfWeek(firstDayOfWeek);
		return cal;
	}
}
