package simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplilearn.model.Todo;
import simplilearn.repository.TodoRepository;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {
	
	// depends on 'TodoRepository'
	
	private TodoRepository todoRepository ;
	
	public TodoServiceImpl() {
		super();
	}
	
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		System.out.println("spring ioc container invoked constructor to assemble 'todoRepository' bean");
		this.todoRepository = todoRepository;
	}

	@Autowired
	public void setTodoRepository(TodoRepository todoRepository) {
		System.out.println("spring ioc container invoked setter method to assemble 'todoRepository' bean");
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
