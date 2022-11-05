package simplilearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import simplilearn.repository.TodoRepository;
import simplilearn.repository.TodoRepositoryImpl;
import simplilearn.services.TodoService;
import simplilearn.services.TodoServiceImpl;

@Configuration
public class AppConfig {
	@Bean(name="todoRepository")
	public TodoRepository todoRepository(){
		TodoRepositoryImpl todoRepositoryBean = new TodoRepositoryImpl();
		return todoRepositoryBean;
	}
	
	@Bean(name="todoService")
	public TodoService todoService() {
		
		TodoServiceImpl todoServiceBean = new TodoServiceImpl();
		todoServiceBean.setTodoRepository(todoRepository());
		return todoServiceBean;
		
	}

}
