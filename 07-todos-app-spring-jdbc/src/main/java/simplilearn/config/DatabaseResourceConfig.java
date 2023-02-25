package simplilearn.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseResourceConfig {
	

	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//cj.jdbc.driver is advanced version of jdbc.driver
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/studentdb");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		return driverManagerDataSource;
	}

}
