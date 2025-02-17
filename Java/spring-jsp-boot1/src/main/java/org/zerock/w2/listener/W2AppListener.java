package org.zerock.w2.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
public class W2AppListener implements ServletContextListener{
	/**
	 * 처음에 톰캣 servlet이 시작될 때 작동하는 메소드
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		
		log.info("----------init-------------------------------");
		log.info("----------init-------------------------------");
		log.info("----------init-------------------------------");
		
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("appName", "W2");
	}
	
	/**
	 * 처음에 톰캣 servlet이 종료될 때 작동하는 메소드
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	
		log.info("----------destroy-------------------------------");
		log.info("----------destroy-------------------------------");
		log.info("----------destroy-------------------------------");
	}
}
