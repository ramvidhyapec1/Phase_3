package simplilearn.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import simplilearn.model.Todo;

@Repository(value="todoRepository")
public class TodoRepositoryImpl implements TodoRepository {
	
	private static List<Todo> todosList = new ArrayList<>();
	private static int counter=0;
	
	static{
		todosList.add(new Todo(++counter, "Vidya", "Learn Java", new Date(), false));
		todosList.add(new Todo(++counter, "Vidya", "Learn JavaScript", new Date(), false));
		todosList.add(new Todo(++counter, "Vidya", "Learn Devops", new Date(), false));
		}
			

	@Override
	public Todo save(Todo theTodoObject) {
		if(theTodoObject.getId()==-1 || theTodoObject.getId()==0) {
			theTodoObject.setId(++counter);
			todosList.add(theTodoObject);
		}else {
			deleteById(theTodoObject.getId());
			todosList.add(theTodoObject);
		}
		return theTodoObject;
	}

	@Override
	public Todo findById(long theId) {
		for (Todo theTodo :todosList) {
			if(theTodo.getId() == theId) {
				return theTodo;
			}else {
				return null;
			}
		} return null;
		
		
	}

	@Override
	public List<Todo> findAll() {
		
		return todosList;
	}

	@Override
	public Todo deleteById(long theId) {
		Todo theTodo=findById(theId);
		if(theTodo ==null) {
			return null;
		}
		if(todosList.remove(theTodo)) {
			return theTodo;
		}
		return null;
	}

}
