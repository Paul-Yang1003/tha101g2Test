package core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import core.util.HibernateUtilX;

//@WebListener
public class HibernateListenerX implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtilX.getSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtilX.shutdown();
	}
}
