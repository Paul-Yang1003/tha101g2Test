package core.filter;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core.util.HibernateUtilX;

//@WebFilter("/*")
public class HibernateFilterX extends HttpFilter {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) {
		Session session = HibernateUtilX.getSessionFactory().getCurrentSession();
		try {
			Transaction transaction = session.beginTransaction();
			chain.doFilter(req, res);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}

