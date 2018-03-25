package com.tricon.EmailSchedularService.Controller;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.tricon.EmailSchedularService.ServiceImpl.EmailSendingService;

@Controller
public class EmailSchedulingController {
	
	private static final Logger log = LoggerFactory.getLogger(EmailSchedulingController.class);	
	
	@Autowired
	EmailSendingService emailSendingService;
	

	 @Scheduled(cron="${CronExpression}")
	    public void sendingEmails() {
	        log.info("The time is now {}",new Timestamp(System.currentTimeMillis()));
	        try{
	        	emailSendingService.sendEmails();
	        }
	        catch(Exception e){
	        	System.out.println("Exception Occurred in the method sendingEmails and the exception is : "+e.getMessage());
	        }
	    }

}
