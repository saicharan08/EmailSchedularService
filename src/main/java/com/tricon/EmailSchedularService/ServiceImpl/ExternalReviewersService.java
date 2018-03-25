package com.tricon.EmailSchedularService.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tricon.EmailSchedularService.IService.IExternalReviewersService;

@Service
public class ExternalReviewersService implements IExternalReviewersService{
	
	private static final Logger log = LoggerFactory.getLogger(ExternalReviewersService.class);
	
	public static void  fetchAllExternalReviewersDetails() throws Exception{
		
		log.info("In the method fetchAllExternalReviewersDetails");
		
		
		
		
	}

}
