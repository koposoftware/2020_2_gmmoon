package kr.ac.hanalife.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogBack {
	
	private static final Logger log = LoggerFactory.getLogger(LogBack.class);
	
	 public void infoLog(String category, String message) {
	      log.info("[ " + category + " ] " + message);
	 }
	 
	
}
