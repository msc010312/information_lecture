package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class ServletListener4 implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
	
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}

	

}
