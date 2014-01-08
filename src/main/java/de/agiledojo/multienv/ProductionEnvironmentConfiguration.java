package de.agiledojo.multienv;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring configuration for production profile
 * 
 */
@Configuration
@Profile("production")
@PropertySource("classpath:/de/agiledojo/multienv/conf/production.properties")
public class ProductionEnvironmentConfiguration {

}
