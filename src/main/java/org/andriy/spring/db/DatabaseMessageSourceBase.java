package org.andriy.spring.db;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.context.support.AbstractMessageSource;

/**
 * Based on http://blog.javaforge.net/post/32188367580/database-driven-message-source-in-spring
 */
public class DatabaseMessageSourceBase extends AbstractMessageSource {

	private static final Logger log = Logger.getLogger(DatabaseMessageSourceBase.class.getName());


	private Messages messages;
	
	// The testDI argument is used for Dependency Injection test, so can be removed from this constructor
	public DatabaseMessageSourceBase(String testDI) {
		log.info(">>Initializing MessageSource");
		log.info("Dependency Injection message: "+testDI);
		this.messages = ExtractMessageDAO.extractMessages();
	}

	// This function is used for Dependency Injection test, so can be removed
	public void setTestValue(String testDI){
		log.info("Dependency Injection message: "+testDI);
	}
	
	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		String msg = messages.getMessage(code, locale);
		return createMessageFormat(msg, locale);

	}


	/**
	 * 
	 * Messages bundle
	 */
	protected static final class Messages {

		/* <code, <locale, message>> */
		private Map<String, Map<Locale, String>> messages;

		public void addMessage(String code, Locale locale, String msg) {

			if (messages == null){
				messages = new HashMap<String, Map<Locale, String>>();
			}

			Map<Locale, String> data = messages.get(code);
			if (data == null) {
				data = new HashMap<Locale, String>();
				messages.put(code, data);
			}

			data.put(locale, msg);
		}

		public String getMessage(String code, Locale locale) {

			Map<Locale, String> data = messages.get(code);
			return data != null ? data.get(locale) : null;
		}
	}

}