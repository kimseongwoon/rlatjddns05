package org.zerock.w2.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {

	/**
	 * session.setAttribute()가 실행될 때마다 실행되는 메소드
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeAdded(se);
		
		String name = se.getName();
		Object value = se.getValue();
		
		if(name.equals("loginInfo")) {
			log.info("A user logined...........");
			log.info(value);
		}
	}

}
