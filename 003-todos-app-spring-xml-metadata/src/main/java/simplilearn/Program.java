package simplilearn;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import simplilearn.model.Todo;
import simplilearn.services.TodoService;
import simplilearn.services.TodoServiceImpl;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//TodoService theTodoService = new TodoServiceImpl();
		TodoService theTodoService= context.getBean("todoService", TodoService.class);
		
		//find al todos
		List<Todo> todosList= theTodoService.findAll();
		
		//Traverse the list and display the contents
		todosList.forEach(todo -> System.out.println(todo.getDescription()));
		
		//Find by ID
		Todo theTodo = theTodoService.findById(1);
		System.out.println("------------->"+theTodo.getDescription());
		
		//test Save method
		
		Todo saveTodo = theTodoService.save(new Todo(4,"Vidya","Learn Python", new Date(), false));
		System.out.println("After saving "+saveTodo.getDescription());
		
		//Delete by Id method
		Todo deleteTodo =theTodoService.deleteById(1);
		System.out.println(deleteTodo.getId());
		
		
		//Traverse the list and display the contents
				todosList.forEach(todo -> System.out.println(todo.getDescription()));
				
				System.out.println(todosList);

	}

}
