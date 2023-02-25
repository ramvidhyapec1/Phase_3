package simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import simplilearn.model.Todo;
import simplilearn.repository.TodoRepository;
import simplilearn.repository.TodoRepositoryImpl;
import simplilearn.events.TodoEvent;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService, ApplicationEventPublisherAware {

	//depends on TodoRepository

	private TodoRepository todoRepository;
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;

	}	

	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		System.out.println("The Spring IOC container invoked the constructor method to assemble ");
		this.todoRepository = todoRepository;
	}

	@Autowired
	public void setTodoRepository(TodoRepository todoRepository) {
		System.out.println("Spring IOC container invoked setter method to assemble 'todoRepository' bean ");
		this.todoRepository = todoRepository;
	}


	@Override
	public Todo save(Todo theTodoObject) {
		applicationEventPublisher.publishEvent(new TodoEvent(this,"Saving the Todo"));
		return todoRepository.save(theTodoObject);
	}

	@Override
	public Todo findById(long theId) {
		applicationEventPublisher.publishEvent(new TodoEvent( this, "Find All Todos"));
		return todoRepository.findById(theId);
	}

	@Override
	public List<Todo> findAll() {
		applicationEventPublisher.publishEvent(new TodoEvent(this, "Listing all Todos"));
		return todoRepository.findAll();
	}

	@Override
	public Todo deleteById(long theId) {
		applicationEventPublisher.publishEvent(new TodoEvent(this, "Delting the Todos with ID : "+theId));
		return todoRepository.deleteById(theId);
	}


};




