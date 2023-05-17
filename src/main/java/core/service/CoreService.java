package core.service;

import org.hibernate.Transaction;

import core.util.HibernateUtilX;

public interface CoreService {

//	default Transaction beginTransaction() {
//		return HibernateUtilX.getSessionFactory().getCurrentSession().beginTransaction();
//	}
//
//	default void commit() {
//		HibernateUtilX.getSessionFactory().getCurrentSession().getTransaction().commit();
//	}
//
//	default void rollback() {
//		HibernateUtilX.getSessionFactory().getCurrentSession().getTransaction().rollback();
//	}
}
