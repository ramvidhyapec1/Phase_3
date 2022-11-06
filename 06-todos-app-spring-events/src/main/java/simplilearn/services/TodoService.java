package simplilearn.services;

import java.util.List;

import simplilearn.model.Todo;

public interface TodoService {

	public List<Todo> findAll();
	public Todo findById( long theId );
	public Todo save ( Todo theTodo );
	public Todo deleteById ( long theId );
	
}