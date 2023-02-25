package simplilearn.services;

import java.util.List;



import simplilearn.model.Todo;


public interface TodoService {
	
	
	public Todo save(Todo theTodoObject); //used for saving the todo object 
	public Todo findById(long theId); // used for finding the To do list by ID
	public List<Todo> findAll();	 // used to display the list of to do objects created
	public Todo deleteById(long theId);  //used to delete a to do list object when we give an id 

}
