package com.tricon.EmailSchedularService.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tricon.EmailSchedularService.IDao.IExternalReviewersDao;
import com.tricon.EmailSchedularService.vo.AppraisalCycleProperties;

@Repository
public class ExternalReviewersDao implements IExternalReviewersDao {
	
	private static final Logger log = LoggerFactory.getLogger(ExternalReviewersDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public  void  fetchAllExternalReviewers() throws Exception{
		
		log.debug("In the method fetchAllExternalReviewers of ExternalReviewersDao class");
		
		List<AppraisalCycleProperties> appraisalCycleProperties = jdbcTemplate.query(FETCH_EXTERNAL_REVIEWERS_DETAILS, new RowMapper<AppraisalCycleProperties>() {
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
		
		
		
		
		
	}

}
