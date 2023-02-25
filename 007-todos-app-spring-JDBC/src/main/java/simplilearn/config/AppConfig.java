package simplilearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration

@ComponentScan(basePackages = "simplilearn.repository, simplilearn.services" )
@Import(value=DatabaseResourceconfig.class)
public class AppConfig {
	
}
