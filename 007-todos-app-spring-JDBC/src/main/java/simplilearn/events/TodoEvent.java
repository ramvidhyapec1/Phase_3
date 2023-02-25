package simplilearn.events;

import org.springframework.context.ApplicationEvent;



import simplilearn.repository.TodoRepository;


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
