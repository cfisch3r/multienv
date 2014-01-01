package de.agiledojo.multienv.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/de/agiledojo/multienv/conf/default.properties")
@Import(ProductionEnvironmentConfiguration.class)
public class DefaultEnvironmentConfiguration {
}
