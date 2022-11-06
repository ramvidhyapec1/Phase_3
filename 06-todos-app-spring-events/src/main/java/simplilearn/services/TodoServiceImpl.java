	package simplilearn.services;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.ApplicationEventPublisher;
	import org.springframework.context.ApplicationEventPublisherAware;
	import org.springframework.stereotype.Service;

	import simplilearn.events.TodoEvent;
	import simplilearn.model.Todo;
	import simplilearn.repository.TodoRepository;

	// event publisher
	@Service(value = "todoService")
	public class TodoServiceImpl implements TodoService , ApplicationEventPublisherAware {
		
		private ApplicationEventPublisher applicationEventPublisher;

		@Override
		public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
			this.applicationEventPublisher = applicationEventPublisher;
		}
		
			// TODO Auto-generated method stub
			
		
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
			applicationEventPublisher.publishEvent(new TodoEvent(this, "FIND ALL TODOS"));
			return todoRepository.findAll();
		}

		@Override
		public Todo findById(long theId) {
			applicationEventPublisher.publishEvent(new TodoEvent(this, "FIND TODO BY ID"));
			return todoRepository.findById(theId);
		}

		@Override
		public Todo save(Todo theTodo) {
			applicationEventPublisher.publishEvent(new TodoEvent(this, "SAVE TODO"));
			return todoRepository.save(theTodo);
		}

		@Override
		public Todo deleteById(long theId) {
			applicationEventPublisher.publishEvent(new TodoEvent(this, "DELETE TODO"));
			return todoRepository.deleteById(theId);
		}



	}