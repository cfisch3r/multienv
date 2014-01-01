package de.agiledojo.multienv.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("production")
@PropertySource("classpath:/de/agiledojo/multienv/conf/production.properties")
public class ProductionEnvironmentConfiguration {

}
