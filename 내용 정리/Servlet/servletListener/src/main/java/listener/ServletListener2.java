package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener2 implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Listener add");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Listener remove");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Listener replaced");
	}

}
