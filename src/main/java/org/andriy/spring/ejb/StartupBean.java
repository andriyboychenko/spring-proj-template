package org.andriy.spring.ejb;

import java.util.List;

import org.andriy.spring.entities.I18NMessage;
import org.andriy.spring.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class StartupBean {
	
	private static final Logger log = Logger.getLogger(StartupBean.class.getName());
	
	public void initialize() {
		
		log.info(">>Initializing StartupBean");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();

			I18NMessage i18n = new I18NMessage();
			i18n.setMessageCode("message.say.hello");
			i18n.setMessageRU("Privet");
			i18n.setMessagePT("Olá");
			i18n.setMessageEN("Hi");
			
			session.save(i18n);
	         
			tx.commit();
		   
		} catch (Exception e) {
			
			if (tx != null){
				tx.rollback();
			}
			e.printStackTrace(); 
			
		} finally {
			
		   session.close();
		   
		}
		
	}

}
