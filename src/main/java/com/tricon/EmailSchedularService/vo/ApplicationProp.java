package com.tricon.EmailSchedularService.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationProp implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String envVariable;
	private static int envMinValue;
	private static int envMaxValue;
	
	private static ArrayList<String> kpiDisplayName=new ArrayList<String>();
	private static ArrayList<Integer> kpiId=new ArrayList<Integer>();
	private static ArrayList<String> kpiCode=new ArrayList<String>();
	
	private static ArrayList<String> appraisalCycle=new ArrayList<String>();
	private static ArrayList<String> durationFrom=new ArrayList<String>();
	private static ArrayList<String> durationTo=new ArrayList<String>();
	
	private static Map<String,String> appraisalCycleCode = new HashMap<String,String>(); 
	
	public static Map<String, String> getAppraisalCycleCode() {
		return appraisalCycleCode;
	}
	public static void setAppraisalCycleCode(Map<String, String> appraisalCycleCode) {
		ApplicationProp.appraisalCycleCode = appraisalCycleCode;
	}
	private static List<AppraisalCycleProperties> appraisalCycleProperties;
	
	private static Map<String,Integer> textArea=new HashMap<String,Integer>();  
	
	private static int probationMonths;
	
	private static Map<Integer,String> project=new HashMap<Integer,String>();
	
	private static Map<String,Integer> totalDaysForCycle = new HashMap<String, Integer>();

	private static Map<Integer,String> status=new HashMap<Integer,String>();
	
	public static Map<Integer, String> getStatus() {
		return status;
	}
	public static void setStatus(Map<Integer, String> status) {
		ApplicationProp.status = status;
	}
	public static int getKeyFromValue(Map<Integer, String> hm, String value) {
	    for (int o : hm.keySet()) {
	      if (hm.get(o).equals(value)) {
	        return o;
	      }
	    }
	    return 0;
	  }
	public static int getProbationMonths() {
		return probationMonths;
	}
	public static void setProbationMonths(int probationMonths) {
		ApplicationProp.probationMonths = probationMonths;
	}

	public static Map<Integer, String> getProject() {
		return project;
	}
	public static void setProject(Map<Integer, String> project) {
		ApplicationProp.project = project;
	}
	public static Map<String, Integer> getTextArea() {
		return textArea;
	}
	public static void setTextArea(Map<String, Integer> textArea) {
		ApplicationProp.textArea = textArea;
	}
	public static ArrayList<String> getKpiDisplayName() {
		return kpiDisplayName;
	}
	public static void setKpiDisplayName(ArrayList<String> kpiDisplayName) {
		ApplicationProp.kpiDisplayName = kpiDisplayName;
	}
	public static ArrayList<Integer> getKpiId() {
		return kpiId;
	}
	public static void setKpiId(ArrayList<Integer> kpiId) {
		ApplicationProp.kpiId = kpiId;
	}
	public static ArrayList<String> getKpiCode() {
		return kpiCode;
	}
	public static void setKpiCode(ArrayList<String> kpiCode) {
		ApplicationProp.kpiCode = kpiCode;
	}
	public static ArrayList<String> getAppraisalCycle() {
		return appraisalCycle;
	}
	public static void setAppraisalCycle(ArrayList<String> appraisalCycle) {
		ApplicationProp.appraisalCycle = appraisalCycle;
	}
	public static ArrayList<String> getDurationFrom() {
		return durationFrom;
	}
	public static void setDurationFrom(ArrayList<String> durationFrom) {
		ApplicationProp.durationFrom = durationFrom;
	}
	public static ArrayList<String> getDurationTo() {
		return durationTo;
	}
	public static void setDurationTo(ArrayList<String> durationTo) {
		ApplicationProp.durationTo = durationTo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getEnvVariable() {
		return envVariable;
	}
	public static void setEnvVariable(String envVariable) {
		ApplicationProp.envVariable = envVariable;
	}
	public static int getEnvMinValue() {
		return envMinValue;
	}
	public static void setEnvMinValue(int envMinValue) {
		ApplicationProp.envMinValue = envMinValue;
	}
	public static int getEnvMaxValue() {
		return envMaxValue;
	}
	public static void setEnvMaxValue(int envMaxValue) {
		ApplicationProp.envMaxValue = envMaxValue;
	}
	public static Map<String, Integer> getTotalDaysForCycle() {
		return totalDaysForCycle;
	}
	public static void setTotalDaysForCycle(Map<String, Integer> totalDaysForCycle) {
		ApplicationProp.totalDaysForCycle = totalDaysForCycle;
	}
	public static List<AppraisalCycleProperties> getAppraisalCycleProperties() {
		return appraisalCycleProperties;
	}
	public static void setAppraisalCycleProperties(
			List<AppraisalCycleProperties> appraisalCycleProperties) {
		ApplicationProp.appraisalCycleProperties = appraisalCycleProperties;
	}
	
	
}