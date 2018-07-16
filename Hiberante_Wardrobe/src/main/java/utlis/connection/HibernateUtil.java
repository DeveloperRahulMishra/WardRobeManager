/**
 * 
 */
package utlis.connection;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Rahul
 *
 */
public class HibernateUtil {

	/**
	 * sessionFactory
	 */
	private static SessionFactory sessionFactory;

	/**
	 * getSessionFactory
	 * 
	 * @return SessionFactory
	 * @throws HibernateException
	 */
	public static SessionFactory getSessionFactory() throws HibernateException {

		/*
		 * SessionFactory sf = null;
		 * 
		 * Configuration config = new Configuration();
		 * 
		 * config.configure("hibernate.cfg.xml");
		 * 
		 * ServiceRegistry sr = new StandardServiceRegistryBuilder()
		 * .applySettings(config.getProperties()).build();
		 * 
		 * sf = config.buildSessionFactory(sr);
		 */
		// Above hibernate 5

		return new Configuration().configure().buildSessionFactory();

	}

	/**
	 * isConnectionExists
	 * 
	 * @return
	 */
	public static boolean checkConnection() {

		boolean connectionStatus = false;
		try {
			sessionFactory = getSessionFactory();
			connectionStatus = (sessionFactory != null) ? true : false;
		} catch (HibernateException he) {
			throw new HibernateException(he.getMessage());
		}
		return connectionStatus;
	}

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Session getSession() throws HibernateException {

		Session session = null;
		try {
			if (sessionFactory == null) {
				sessionFactory = HibernateUtil.getSessionFactory();
			}
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException he) {
			throw new HibernateException(he);
		}
		return session;
	}

	/**
	 * 
	 * @param session
	 * @throws HibernateException
	 */
	public void beginTransaction(Session session) throws HibernateException {

		try {
			session.beginTransaction();
			// Session will be closed automatically
			// openSession need to manually close
		} catch (HibernateException he) {
			throw new HibernateException(he.getMessage());
		}
	}

	/**
	 * 
	 * @param session
	 * @throws HibernateException
	 */
	public void commitTransaction(Session session) throws HibernateException {

		try {
			session.getTransaction().commit();
			// session.flush();
		} catch (HibernateException he) {
			throw new HibernateException(he.getMessage());
		}
	}

	/**
	 * 
	 * @param session
	 * @param entity
	 * @throws HibernateException
	 */
	public Object saveEntity(Session session, Object entity)
			throws HibernateException {
		try {
			return session.save(entity);
		} catch (HibernateException he) {
			throw new HibernateException(he.getMessage());
		}
	}

	/**
	 * save
	 * 
	 * @param <T>
	 * 
	 * @param obj
	 * @return
	 */
	public <T> Object listQuery(Class<T> obj, String query,
			Map<String, Object> queryData) {
		List<Object> item = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Object primaryKey = null;
		if (sessionFactory != null) {

			// Session will be closed automatically
			// openSession need to manually close
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Query queryHibernate = session.createQuery(query);
			for (Map.Entry<String, Object> entry : queryData.entrySet()) {
				queryHibernate.setParameter(entry.getKey(), entry.getValue());
			}

			item = queryHibernate.list();

			session.getTransaction().commit();
		}

		return item;

	}

	/**
	 * save
	 * 
	 * @param obj
	 * @return
	 */
	public void persists(Object obj) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Object primaryKey = null;
		if (sessionFactory != null) {

			// Session will be closed automatically
			// openSession need to manually close
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			session.persist(obj);

			session.getTransaction().commit();
		}

	}

	public Query createQuery(String query) {
		// TODO Auto-generated method stub
		Query query1 = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		if (sessionFactory != null) {

			// sesssionn will be closed automatically
			// openSession need to manually close
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			query1 = session.createQuery(query);

			// error on closing
			// session.getTransaction().commit();
		}
		return query1;

	}

	public static void closeConnection() {

		if (!sessionFactory.isClosed()) {

			sessionFactory.close();
		}
	}
	

}
