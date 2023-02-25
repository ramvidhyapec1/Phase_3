package simplilearn.services;

import java.util.List;

import simplilearn.model.Todo;
import simplilearn.repository.TodoRepository;
import simplilearn.repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService {
	
	//depends on TodoRepository
	
	private TodoRepository todoRepository = new TodoRepositoryImpl() ;
		
		@Override
		public Todo save(Todo theTodoObject) {
			return todoRepository.save(theTodoObject);
		}
		
		@Override
		public Todo findById(long theId) {
			return todoRepository.findById(theId);
		}
		
		@Override
		public List<Todo> findAll() {
			
			return todoRepository.findAll();
		}
		
		@Override
		public Todo deleteById(long theId) {
			
			return todoRepository.deleteById(theId);
		}
	};

	


