package simplilearn.services;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import simplilearn.events.TodoEvent;

@Component
public class TodoEventSubscriber implements ApplicationListener<TodoEvent>{

	@Override
	public void onApplicationEvent(TodoEvent event) {
		System.out.println("Todo : " + event.getType());
	}

}
