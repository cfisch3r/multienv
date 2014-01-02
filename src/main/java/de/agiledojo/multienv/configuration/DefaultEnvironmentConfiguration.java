package de.agiledojo.multienv.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import de.agiledojo.multienv.SampleBean;

@Configuration
@PropertySource("classpath:/de/agiledojo/multienv/conf/default.properties")
@Import(ProductionEnvironmentConfiguration.class)
public class DefaultEnvironmentConfiguration {

	@Value("${sample}")
	private String sampleProperty;

	@Bean
	@Autowired
	public SampleBean createSampleBean() {
		return new SampleBean(sampleProperty);
	}
}
