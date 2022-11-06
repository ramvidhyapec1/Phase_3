package simplilearn.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import simplilearn.model.Todo;

@Repository(value = "todoRepository")
public class TodoRepositoryImpl implements TodoRepository {
	
	private static List<Todo> todosList = new ArrayList<>();
	private static int counter = 0;
	
	static {
		todosList.add(new Todo(++counter, "vinodh", "Learn to dance", new Date(), false));
		todosList.add(new Todo(++counter, "vinodh", "Learn to walk", new Date(), false));
		todosList.add(new Todo(++counter, "vinodh", "Learn to sing", new Date(), false));
	}

	@Override
	public List<Todo> findAll() {
		return todosList;
	}

	@Override
	public Todo findById(long theId) {
		for ( Todo theTodo : todosList ) {
			if ( theTodo.getId() == theId) {
				return theTodo;
			}
		}
		return null;
	}

	@Override
	public Todo save(Todo theTodo) {
		if ( theTodo.getId() == -1 || theTodo.getId() == 0) {
			//set the id for Todo
			theTodo.setId(++counter);
			todosList.add(theTodo);
		}else {
			deleteById(theTodo.getId());
			todosList.add(theTodo);
		}
		
		return theTodo;
	}

	@Override
	public Todo deleteById(long theId) {
		Todo theTodo = findById(theId); // Retrieve  from list
		
		if ( theTodo == null ) 
			return null;
		
		if ( todosList.remove(theTodo)) {
			return theTodo;
		}
		
		return null;
	}

}
