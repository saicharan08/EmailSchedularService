package com.tricon.EmailSchedularService.Util;
import com.tricon.EmailSchedularService.vo.ApplicationProp;

public class Constants {
	
	public static final String NOT_APPLICABLE_DESIGNATION = "NA";

	public static final int OPEN=10;
	
	public static final int INPROGRESS=20;
	
	public static final int EMPLOYEE_SUBMITTED=30;
	
	public static final int REVIEW_INPROGRESS=40;
	
	public static final int REVIEW_COMPLETED=50;
	
	public static final int NOT_ELIGIBLE=60;
	
	public static final String OPEN_STATUS=ApplicationProp.getStatus().get(OPEN);
	
	public static final String INPROGRESS_STATUS=ApplicationProp.getStatus().get(INPROGRESS);
	
	public static final String EMPLOYEE_SUBMITTED_STATUS=ApplicationProp.getStatus().get(EMPLOYEE_SUBMITTED);
	
	public static final String REVIEW_INPROGRESS_STATUS=ApplicationProp.getStatus().get(REVIEW_INPROGRESS);
	
	public static final String REVIEW_COMPLETED_STATUS=ApplicationProp.getStatus().get(REVIEW_COMPLETED);
	
	public static final String NOT_ELIGIBLE_STATUS=ApplicationProp.getStatus().get(NOT_ELIGIBLE);
	
	public static final String FIRST_APPRAISAL_CYCLE="H1";
	
	public static final String PROBATION_CYCLE="PN";
	
	public static final String PIP_CYCLE="PIP";
	
	public static final String SAVE_ACTION="save";
	
	public static final String SUBMIT_ACTION="submit";
	
	public static final String TECHNICAL_TRAINING="T";
	
	public static final String NON_TECHNICAL_TRAINING="NT";
	
	public static final String OTHERS="others";
	
	public static final String SAVE_REVIEW_ACTION="save review";
	
	public static final String SUBMIT_REVIEW_ACTION="submit review";
	
	public static final String SELF="SELF";
	
	public static final String MANAGER="MANAGER";
	
	public static final String TAGGED_MANAGER="TAGGED MANAGER";
	
	public static final String NO_RELATIONSHIP="NO RELATIONSHIP";
	
	public static final int MILLI_TO_SECONDS_CONVERTER=1000;
	
	public static final boolean  OAUTH_ENABLED=true;
	
	public static final String ADD_JSP="/add";
	
	public static final String REVIEW_JSP="/review";
	
	public static final String VIEW_JSP="/view";
	
	public static final String DASHBOARD_JSP="/dashboard";
	
	public static final String LOGIN_JSP="/login";
	
	public static final String ERROR_JSP="/error";
	
	public static final String Static_Content="/static-content";
	
	public static final String APPRAISAL="/appraisal";
	
	public static final String ENVIRONMENT_VARIABLE_URL="/environmentvalue";
	
	public static final String CYCLES="/cycles/";
	
	public static final String ASSOCIATE_CYCLES="/associatescycles/";
	
	public static final String APPRAISALS="/appraisals/";
	
	public static final String ASSOCIATE_APPRAISALS="/associateappraisals/";
	
	public static final String LOGIN_CREDENTIALS_CHECK_URL="/loginController";
	
	public static final int MAX_TRAINING_LENGTH=100;
	
	public static final String EMPLOYEE_CATEGORY_PERMANENT = "P";
	
	public static final String EMPLOYEE_CATEGORY_TEMPORARY = "T";
	
	public static final String EMPLOYEE_TYPE_FRESHER = "F";
	
	public static final String EMPLOYEE_TYPE_LATERAL = "L";
	
	/*	
	Training Dao Constant 
	*/

	public static final String FETCHING_TRAINING_BY_TYPE = "SELECT * from trainings where type=? ORDER BY name DESC";
	
	public static final String INSERT_APPRAISAL_TRAINING="INSERT INTO employee_training_ref(appraisal_cycle_id,training_id)  Select ?,id from trainings where (LOWER(`name`)=?) AND type=?";
	
	public static final String DELETE_TRAINING="Delete from employee_training_ref where appraisal_cycle_id=?";
	
    public static final String INSERT_TRAINING="INSERT into trainings(type,name,subject)values(?,?,?)";
    
    public static final String RETRIEVING_NONTECH_TRAINING = "select name from trainings where id IN (Select training_id from employee_training_ref where appraisal_cycle_id=? AND type='NT') ORDER BY name DESC";
    
	public static final String RETRIEVING_TECH_TRAINING = "select name from trainings where id IN (Select training_id from employee_training_ref where appraisal_cycle_id=? AND type='T')ORDER BY name DESC";

    public static final String FETCH_TRAINING ="select name from trainings where type=?";
    
    /*    
    Total Rating Dao Constants
    */
    public static final String RETRIEVING_TOTAL_RATING="SELECT total_rating FROM total_ratings where appraisal_cycle_id=?";

    public static final String INSERT_TOTAL_RATING="INSERT INTO total_ratings(appraisal_cycle_id,total_rating) values(?,?)";
    
    public static final String DELETE_TOTAL_RATING="DELETE FROM total_ratings where appraisal_cycle_id=?";
    
    /*
    Appraisal DAO Constants
    */
    public static final String INSERT_APPRAISAL_CYCLE="INSERT INTO Appraisal_Cycle(appraisal_cycle_properties_id, cycle_period_from, cycle_period_to, mgr_id, created_on, updated_on, created_by, updated_by, empid, status_id) VALUES ((select id from appraisal_cycle_properties where appraisal_cycle = ?),?,?,?,?,?,?,?,?,?)";
    
    public static final String FETCHING_APPRAISAL_ID = "SELECT id from appraisal_cycle where cycle_period_to=? and empid=?";
    
    public static final String FETCHING_APPRAISAL_STATUS_CODE = "SELECT code from appraisal_status where id=(SELECT status_id from appraisal_cycle where id=?)";

    public static final String UPDATE_APPRAISAL_CYCLE_FOR_SELF = "update Appraisal_Cycle SET updated_on =?, updated_by=?, status_id=? where id =? ";
	
    public static final String UPDATE_APPRAISAL_CYCLE_FOR_ASSOCIATE = "update Appraisal_Cycle SET updated_on =?, updated_by=?,status_id=? where id =? ";
    
    public static final String INSERT_APPRAISAL_DETAIL_FOR_SELF = "INSERT INTO Appraisal_Detail(appraisal_cycle_id, sno, appraisal_kpi_id, objectives, weightage,achievement_self_assesment, accomplish) VALUES (?,?,(select id from appraisal_kpi where display_name=?),?,?,?,?) ON DUPLICATE KEY UPDATE appraisal_kpi_id = (select id from appraisal_kpi where display_name=?), objectives = ?, weightage = ?, achievement_self_assesment = ?, accomplish = ?";
    
    public static final String UPDATE_APPRAISAL_REVIEW_DETAIL = "INSERT INTO appraisal_review_detail(appraisal_detail_id, remark, performance_rating, final_assessment, appraisal_reviewer_id) VALUES ((select id from appraisal_detail where appraisal_cycle_id=? and sno = ?),?,?,?,(select id from appraisal_reviewers where appraisal_cycle_id = ? and mgr_id = ?)) ON DUPLICATE KEY UPDATE remark = ?, performance_rating = ?, final_assessment = ?";
    
    public static final String UPDATE_APPRAISAL_REVIEWERS = "insert into appraisal_reviewers(appraisal_cycle_id, mgr_id, created_on, updated_on, created_by, updated_by) values (?,?,now(),now(),?,?)  on duplicate key update updated_on=now(), updated_by=?";
    
    public static final String UPDATE_APPRAISAL_DETAILS_FOR_ASSOCIATE = "UPDATE Appraisal_Detail SET remark = ?, performance_rating = ?, final_assesment = ? where appraisal_cycle_id = ? AND sno = ?";
    
    public static final String MANAGER_COMMENT_UPDATE="INSERT INTO manager_comment(appraisal_cycle_id,mgr_comment,updated_by) VALUES (?,?,?) ON DUPLICATE KEY UPDATE mgr_comment=?, updated_by=?";
    
    public static final String DELETE_APPRAISAL_DETAIL="Delete from appraisal_detail where sno= ? AND appraisal_cycle_id = ? ";
    
    public static final String INSERT_APPRAISAL_PROJECT="INSERT INTO employee_project_ref(appraisal_cycle_id,project_id)  Select ?,id from appraisal_project where (project_name=?)";
   
    public static final String DELETE_FROM_APPRAISAL_PROJECT="Delete from employee_project_ref where appraisal_cycle_id=?";
    
    /*
    AppraisalDetails DAO
    */
    public static final String RETRIEVING_CYCLE_DATES = "select * from appraisal_cycle as ac where id = ?";
    
    public static final String FETCH_EMPLOYEE_CURRENT_DETAILS = "select * from employee where empid = ? and is_archived = false";
	
	public static final String RETRIEVING_MANAGER_DETAILS = "SELECT emp.empid,emp.fname,emp.lname,des.designation from employee emp, employee_designation ed inner join designation as des on ed.designationid = des.id Where emp.empid=ed.Id  and ed.start_date<=? and ed.end_date>=? and ed.is_archived = false and emp.empid = (SELECT mgr_id from appraisal_cycle where appraisal_cycle.id= ?)";
	
	public static final String RETRIEVING_MANAGER_CURRENT_DETAILS = "SELECT * from employee as emp Where  emp.is_archived = false and emp.empid = (SELECT mgr_id from appraisal_cycle where appraisal_cycle.id= ?)";
	
	public static final String RETRIEVING_EMPLOYEE_DETAILS = "(SELECT emp.empid,emp.fname,emp.lname, des.designation from employee emp, employee_designation ed inner join designation as des on ed.designationid = des.id WHERE emp.empid=ed.Id and emp.empid =? and ed.start_date<=? and ed.end_date>=? and ed.is_archived = false)";
	
	public static final String RETRIEVING_LIST_OF_EMPLOYEE_DETAILS = "SELECT empid,fname,lname from employee where empid in (select empid from emp_mgr where mgrid=? and is_archived = false)";
	
	public static final String RETRIEVING_APPRAISAL_CYCLE_DETAILS = "SELECT ac.empid, ac.cycle_period_from, ac.cycle_period_to, ac.status_id from appraisal_cycle ac WHERE ac.id =? ";
	
	public static final String RETRIEVING_APPRAISAL_DETAILS_FOR_MANAGER = "SELECT * FROM appraisal_detail as a_d inner join appraisal_kpi as a_k on a_k.id=a_d.appraisal_kpi_id left join appraisal_review_detail as a_r_d on a_d.id =a_r_d.appraisal_detail_id where a_d.appraisal_cycle_id=? and a_r_d.mgr_id = ? order by a_d.sno";
	
	public static final String RETRIEVING_APPRAISAL_REVIEW_DETAILS = "select a_r_d.remark,a_r_d.performance_rating,a_r_d.final_assessment,a_r_d.appraisal_detail_id from appraisal_review_detail as a_r_d inner join appraisal_detail as a_d on a_d.id=a_r_d.appraisal_detail_id where a_r_d.appraisal_reviewer_id = (select id from appraisal_reviewers where appraisal_cycle_id = ? and mgr_id = ?)";
	
	public static final String RETRIEVING_APPRAISAL_DETAILS = "SELECT * FROM appraisal_detail as a_d inner join appraisal_kpi as a_k on a_k.id=a_d.appraisal_kpi_id where appraisal_cycle_id=? order by a_d.sno";
	
	public static final String RETRIEVING_MANAGER_COMMENT="select mgr_comment from manager_comment where appraisal_cycle_id=? and updated_by =?";
	
	public static final String RETRIEVING_CYCLE_PROJECTS="select project_name from appraisal_project where id IN (Select project_id from employee_project_ref where appraisal_cycle_id=?)";
	
	/*
	 * CycleYearDao
	 * */
	
	public static final String RETRIEVE_CYCLE_FOR_CURRENT_DATE = "select * from appraisal_cycle as a_c inner join appraisal_cycle_properties as a_c_p on a_c.appraisal_cycle_properties_id = a_c_p.id where str_to_date(a_c.cycle_period_from,'%d-%m-%Y')<=curdate() and str_to_date(a_c.cycle_period_to,'%d-%m-%Y')>=curdate() and a_c.empid = ?";

	/*
	 * ExternalReviewersDao
	 */
	public static final String FETCH_EXTERNAL_REVIEWERS_DETAILS = " ";
}
