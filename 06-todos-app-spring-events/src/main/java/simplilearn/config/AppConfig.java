package simplilearn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan(basePackages = "simplilearn.repository,simplilearn.services")
public class AppConfig {
	
}
