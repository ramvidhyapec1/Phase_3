package simplilearn.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import simplilearn.model.Todo;

public class TodoRepositoryImpl implements TodoRepository {
	
	private static List<Todo> todosList = new ArrayList<>();
	private static int counter=0;
	
	static {
		todosList.add(new Todo(++counter,"vidya","Learn to dance",new Date(),false));
		todosList.add(new Todo(++counter,"vidya","Learn to walk",new Date(),false));
		todosList.add(new Todo(++counter,"vidya","Learn to sing",new Date(),false));
	}

	@Override
	public List<Todo> findAll() {
		return todosList;
	}

	@Override
	public Todo findById(long theId) {
		for(Todo theTodo:todosList) {
			if(theTodo.getId() == theId) {
				return theTodo;
				}
			}
		return null;
	}
//What you wrote
	@Override
	public Todo save(Todo theTodo) {
		if(theTodo.getId() == -1 || theTodo.getId() == 0) {
			theTodo.setId(++counter);
			todosList.add(theTodo);
		}else {
			deleteById(theTodo.getId());
			todosList.add(theTodo);
		}
		
		// TODO Auto-generated method stub
		return theTodo;
	}
	
	

	@Override
	public Todo deleteById(long theId) {
		Todo theTodo=findById(theId); //Retrieve from list
		
		if(theTodo ==null)
			return null;
		
		if(todosList.remove(theTodo)) {
			return theTodo;
		}
	
		return null;
	}

}
