package simplilearn.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import simplilearn.repository.TodoRepository;

@Component
public class TodoEvent extends ApplicationEvent {
	
	private String Type;
		
	public TodoEvent(Object source, String Type) {
		super(source);
		this.Type = Type;
		}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	
	
	

}
