package simplilearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import simplilearn.repository.TodoRepository;
import simplilearn.repository.TodoRepositoryImpl;
import simplilearn.services.TodoService;
import simplilearn.services.TodoServiceImpl;

@Configuration

@ComponentScan(basePackages = "simplilearn.repository, simplilearn.services" )
public class AppConfig {
	
}
