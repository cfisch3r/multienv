package de.agiledojo.multienv.configuration;

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

	@Value("${sample2}")
	private String generalValue;

	@Value("${sample}")
	private String environmentSpecificValue;

	@Bean
	@Autowired
	public SampleBean createSampleBean() {
		return new SampleBean(generalValue, environmentSpecificValue);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
