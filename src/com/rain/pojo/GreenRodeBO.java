package com.rain.pojo;

public class GreenRodeBO {
	//
	private String id;
	
	private String patient;//患者
	private String patientPhone;//患者手机
	private String needService;//需要服务
	private String createTime;//下单时间
	private String state;//状态
	
	
//	private String medicalRecordId;//病例id
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getNeedService() {
		return needService;
	}
	public void setNeedService(String needService) {
		this.needService = needService;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
