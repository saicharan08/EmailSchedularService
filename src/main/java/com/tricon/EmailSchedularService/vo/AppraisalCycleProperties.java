package com.tricon.EmailSchedularService.vo;

public class AppraisalCycleProperties {
	private int id;
	private String category; 
	private String appraisal_cycle;
	private String duration_from;
	private String duration_to;
	private String minimum_no_of_days;
	private String maximum_no_of_days;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAppraisal_cycle() {
		return appraisal_cycle;
	}
	public void setAppraisal_cycle(String appraisal_cycle) {
		this.appraisal_cycle = appraisal_cycle;
	}
	public String getDuration_from() {
		return duration_from;
	}
	public void setDuration_from(String duration_from) {
		this.duration_from = duration_from;
	}
	public String getDuration_to() {
		return duration_to;
	}
	public void setDuration_to(String duration_to) {
		this.duration_to = duration_to;
	}
	public String getMinimum_no_of_days() {
		return minimum_no_of_days;
	}
	public void setMinimum_no_of_days(String minimum_no_of_days) {
		this.minimum_no_of_days = minimum_no_of_days;
	}
	public String getMaximum_no_of_days() {
		return maximum_no_of_days;
	}
	public void setMaximum_no_of_days(String maximum_no_of_days) {
		this.maximum_no_of_days = maximum_no_of_days;
	}
	@Override
	public String toString() {
		return "AppraisalCycleProperties [id=" + id + ", category=" + category
				+ ", appraisal_cycle=" + appraisal_cycle + ", duration_from="
				+ duration_from + ", duration_to=" + duration_to
				+ ", minimum_no_of_days=" + minimum_no_of_days
				+ ", maximum_no_of_days=" + maximum_no_of_days + "]";
	}

}
