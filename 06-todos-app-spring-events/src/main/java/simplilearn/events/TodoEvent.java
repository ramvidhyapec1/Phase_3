package simplilearn.events;

import org.springframework.context.ApplicationEvent;

import simplilearn.repository.TodoRepository;

public class TodoEvent extends ApplicationEvent{
	
	private String type;
	
	

	public TodoEvent(Object source, String type) {
		super(source);
		this.type = type;
	
	}

	public String getType() {
		return type;
	}
	
	
}
