package simplilearn.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import simplilearn.model.Todo;

@Component
public interface TodoRepository {
	
	public Todo save(Todo theTodoObject); //used for saving the todo object 
	public Todo findById(long theId); // used for finding the To do list by ID
	public List<Todo> findAll();	 // used to display the list of to do objects created
	public Todo deleteById(long theId);  //used to delete a to do list object when we give an id 
	

}
