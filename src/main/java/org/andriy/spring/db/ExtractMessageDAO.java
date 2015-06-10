package org.andriy.spring.db;

import java.util.List;
import java.util.Locale;

import org.andriy.spring.db.DatabaseMessageSourceBase.Messages;
import org.andriy.spring.entities.I18NMessage;
import org.andriy.spring.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ExtractMessageDAO {
	
	static Messages extractMessages(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "FROM I18NMessage";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<I18NMessage> results = query.list();
		
		Messages messages = new Messages();
		for (I18NMessage message : results) {
			Locale localePT = new Locale("pt","PT");
			messages.addMessage(message.getMessageCode(), localePT, message.getMessagePT());
			Locale localeRU = new Locale("ru","RU");
			messages.addMessage(message.getMessageCode(), localeRU, message.getMessageRU());
			Locale localeEN = new Locale("en","US");
			messages.addMessage(message.getMessageCode(), localeEN, message.getMessageEN());
		}
		
		
		return messages;
	}

}
