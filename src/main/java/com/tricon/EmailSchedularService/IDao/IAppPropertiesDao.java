package com.tricon.EmailSchedularService.IDao;

public interface IAppPropertiesDao {
	
	/**
	 * fetch application properties from application_properties table
	 */
	public  void getAppProperties();

	/*
	 * fetch appraisal cycle properties
	 */
	public void getAppraisalCycleProperties();

}

