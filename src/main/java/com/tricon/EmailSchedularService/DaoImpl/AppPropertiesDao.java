package com.tricon.EmailSchedularService.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tricon.EmailSchedularService.Controller.EmailSchedulingController;
import com.tricon.EmailSchedularService.IDao.IAppPropertiesDao;
import com.tricon.EmailSchedularService.vo.ApplicationProp;
import com.tricon.EmailSchedularService.vo.AppraisalCycleProperties;

@Repository
public class AppPropertiesDao implements IAppPropertiesDao {

	     private static final Logger logger = LoggerFactory.getLogger(EmailSchedulingController.class);	
		 @Autowired
		 private JdbcTemplate jdbcTemplate;
		 
		 public static final String FETCH_FROM_APPRAISAL_STATUS="select id,code from appraisal_status";
		 
		 public static final String FETCH_FROM_ENVPROPERTIES_SQL="select * from application_properties where ENV_VARIABLE='PROD'";
		 
		 public static final String FETCH_FROM_KPIPROPERTIES_SQL = "select * from appraisal_kpi";
		 
		 public static final String FETCH_FROM_CYCLEPROPERTIES_SQL  = "select * from appraisal_cycle_properties";
		 
		 public static final String FETCH_FROM_CYCLEPROPERTIES_BASED_SQL  = "select * from appraisal_cycle_properties where appraisal_cycle = ? ";
		 
		 public static final String FETCH_FROM_CHARACTERSIZE_SQL = "select * from character_size_configuration";
		 
		 public static final String FETCH_FROM_PROBATION_PERIOD="select no_of_months from probation_period";
	     
	     public static final String FETCH_FROM_APPRAISAL_PROJECT="select id,project_name from appraisal_project"; 
	     
	     public static final String FETCH_TOTAL_DAYS_FOR_EACH_CYCLE = "SELECT appraisal_cycle,maximum_no_of_days FROM appraisal.appraisal_cycle_properties"; 
		
		@PostConstruct
		public   void getAppProperties() {
			try{
			
			ApplicationProp app = jdbcTemplate.query(FETCH_FROM_ENVPROPERTIES_SQL,new ResultSetExtractor<ApplicationProp>(){ 
	                
	                public ApplicationProp extractData(ResultSet rs) throws SQLException, 
	                       DataAccessException { 
	                	ApplicationProp app=new ApplicationProp();
		        if(rs.next()){
		        ApplicationProp.setEnvMinValue(rs.getInt("ENV_MIN_VALUE"));
		        ApplicationProp.setEnvMaxValue(rs.getInt("ENV_MAX_VALUE"));
		    	logger.info("min value"+ ApplicationProp.getEnvMinValue());
		    	logger.info("max value"+ ApplicationProp.getEnvMaxValue());
		    	}
				return app;
				
		    }
		     });
		    ApplicationProp appKpi = jdbcTemplate.query(FETCH_FROM_KPIPROPERTIES_SQL,new ResultSetExtractor<ApplicationProp>(){ 
                
                public ApplicationProp extractData(ResultSet rs) throws SQLException, 
                       DataAccessException { 
                	ApplicationProp app=new ApplicationProp();
			    while (rs.next()) {
			    ApplicationProp.getKpiId().add((rs.getInt("id")));
				ApplicationProp.getKpiCode().add((rs.getString("code")));
				ApplicationProp.getKpiDisplayName().add((rs.getString("display_name")));
			      }
			    return app;
		        }
		    });
		    ApplicationProp appCycle = jdbcTemplate.query(FETCH_FROM_CYCLEPROPERTIES_SQL ,new ResultSetExtractor<ApplicationProp>(){ 
                
                public ApplicationProp extractData(ResultSet rs) throws SQLException, 
                       DataAccessException { 
                	ApplicationProp app=new ApplicationProp();
			        while (rs.next()) {
			        ApplicationProp.getDurationTo().add((rs.getString("duration_to")));
					ApplicationProp.getAppraisalCycle().add((rs.getString("appraisal_cycle")));
					ApplicationProp.getDurationFrom().add(rs.getString("duration_from"));
					ApplicationProp.getAppraisalCycleCode().put(rs.getString("appraisal_cycle_code"), rs.getString("appraisal_cycle"));
			      }
			    return app;
		        }
		    });
            ApplicationProp appCharSize = jdbcTemplate.query(FETCH_FROM_CHARACTERSIZE_SQL ,new ResultSetExtractor<ApplicationProp>(){ 
                
                public ApplicationProp extractData(ResultSet rs) throws SQLException, 
                       DataAccessException { 
                	ApplicationProp app=new ApplicationProp();
			        while (rs.next()) {
				    ApplicationProp.getTextArea().put(rs.getString("textarea_name"), rs.getInt("size"));
			}
			return app;
                }
            });
	
         ApplicationProp appProbationPeriod = jdbcTemplate.query(FETCH_FROM_PROBATION_PERIOD ,new ResultSetExtractor<ApplicationProp>(){ 
             
             public ApplicationProp extractData(ResultSet rs) throws SQLException, 
                    DataAccessException { 
             	ApplicationProp app=new ApplicationProp();
                while (rs.next()) {
				ApplicationProp.setProbationMonths(rs.getInt("no_of_months"));
			}
         return app;
             }
         });
         
        ApplicationProp appStaus = jdbcTemplate.query(FETCH_FROM_APPRAISAL_STATUS ,new ResultSetExtractor<ApplicationProp>(){ 
             
             public ApplicationProp extractData(ResultSet rs) throws SQLException, 
                    DataAccessException { 
             	ApplicationProp app=new ApplicationProp();
               while(rs.next()){
        	   ApplicationProp.getStatus().put(rs.getInt("id"), rs.getString("code"));
         }
               return app;
             }
        });
        ApplicationProp appProject = jdbcTemplate.query(FETCH_FROM_APPRAISAL_PROJECT ,new ResultSetExtractor<ApplicationProp>(){ 
                 
             public ApplicationProp extractData(ResultSet rs) throws SQLException, 
                     DataAccessException { 
                 ApplicationProp app=new ApplicationProp();
                while(rs.next()){
            	ApplicationProp.getProject().put(rs.getInt("id"), rs.getString("project_name"));
          }
                   return app;
                 }
        });
        
		ApplicationProp appTotalDaysForCycle = jdbcTemplate.query(FETCH_TOTAL_DAYS_FOR_EACH_CYCLE ,new ResultSetExtractor<ApplicationProp>(){ 
             
             public ApplicationProp extractData(ResultSet rs) throws SQLException, 
                     DataAccessException { 
                 ApplicationProp app=new ApplicationProp();
                while(rs.next()){
            	ApplicationProp.getTotalDaysForCycle().put(rs.getString("appraisal_cycle"), rs.getInt("maximum_no_of_days"));
          }
                   return app;
                 }
        });
			}catch(Exception e){
				logger.error(""+e.getMessage());
			}

}
		
		 @PostConstruct
			public void getAppraisalCycleProperties() {
				
				List<AppraisalCycleProperties> appraisalCycleProperties = jdbcTemplate.query(FETCH_FROM_CYCLEPROPERTIES_SQL, new RowMapper<AppraisalCycleProperties>() {
					@Override
					public AppraisalCycleProperties mapRow(ResultSet rs, int rownumber) throws SQLException {
						AppraisalCycleProperties appCycleProp = new AppraisalCycleProperties();
						appCycleProp.setAppraisal_cycle(rs.getString("appraisal_cycle"));
						appCycleProp.setId(rs.getInt("id"));
						appCycleProp.setCategory(rs.getString("category"));
						appCycleProp.setDuration_from(rs.getString("duration_from"));
						appCycleProp.setDuration_to(rs.getString("duration_to"));
						appCycleProp.setMaximum_no_of_days(rs.getString("maximum_no_of_days"));
						appCycleProp.setMinimum_no_of_days(rs.getString("minimum_no_of_days"));
						return appCycleProp;
					}
				});
				ApplicationProp.setAppraisalCycleProperties(appraisalCycleProperties);
				
			}
}
			
	
		 

		
		

		
	









