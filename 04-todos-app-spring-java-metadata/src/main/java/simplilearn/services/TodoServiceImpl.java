package simplilearn.services;

import java.util.List;

import simplilearn.model.Todo;
import simplilearn.repository.TodoRepository;
import simplilearn.repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService {
	
	//depends on 'TodoRepository'
	private TodoRepository todoRepository;
	
	public TodoServiceImpl() {
		super();
	}
	
	public void setTodoRepository(TodoRepository todoRepository) {
		System.out.println("spring ioc container invoked setter to assemble 'todoRepository' bean");
		this.todoRepository=todoRepository;
	}
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		System.out.println("spring ioc container invoked constructor to assemble 'todoRepository' bean");
		this.todoRepository = todoRepository;
	}
	
	
	@Override
	public List<Todo> findAll() {		
		return todoRepository.findAll();
	}

	@Override
	public Todo findById(long theId) {
		
		return todoRepository.findById(theId);
	}

	@Override
	public Todo save(Todo theTodo) {
		
		return todoRepository.save(theTodo);
	}

	@Override
	public Todo deleteById(long theId) {
		
		return todoRepository.deleteById(theId);
	}

}
