package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ServletListener3 implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Listener session crate");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Listener session destroyed");
	}

	

}
