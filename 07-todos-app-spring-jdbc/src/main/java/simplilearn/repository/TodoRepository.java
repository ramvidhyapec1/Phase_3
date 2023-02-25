package simplilearn.repository;

import java.util.List;

import simplilearn.model.Todo;

public interface TodoRepository {

	public List<Todo> findAll();
	public Todo findById(long theId);
	public Todo save ( Todo theTodo);
	public Todo deleteById(long theId);
	
}
