package simplilearn;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import simplilearn.config.AppConfig;
import simplilearn.model.Todo;
import simplilearn.services.TodoService;


public class Program {

	public static void main(String[] args) {
		
		//ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		
		//TodoService theTodoService = new TodoServiceImpl();
		TodoService theTodoService= context.getBean("todoService", TodoService.class);
		
		
		//test Save method
		theTodoService.save(new Todo(-1,"Vidya","Learn New things", new Date(), false));
				
		//find all todos
		List<Todo> todosList= theTodoService.findAll();
			
		
		//Traverse the list and display the contents
		todosList.forEach(todo -> System.out.println(todo.getDescription()));
		
		//Find by ID
		Todo theTodo = theTodoService.findById(1);
		System.out.println("------------->"+theTodo.getDescription());
		
		
		//Delete by Id method
		Todo deleteTodo =theTodoService.deleteById(1);
		System.out.println(deleteTodo.getId());
		
		
		//Traverse the list and display the contents
			todosList.forEach(todo -> System.out.println(todo.getDescription()));
				
				System.out.println(todosList);

	}

}
