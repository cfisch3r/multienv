package de.agiledojo.multienv.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/de/agiledojo/multienv/conf/default.properties")
public class DefaultEnvironmentConfiguration {
}
