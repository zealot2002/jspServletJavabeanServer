package com.rain.pojo;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordBO {
	//病例实体类
	
	private String id;
	private String diseaseName;//疾病名称
	private String hospital;//所在医院
	private String department;//所在科室
	private String visitTime;//就诊时间
	
	//info
	private String description;//病情描述
	private String deagnosticInfo;//诊断信息
	private String medication;//用药情况
	
	private List<String> smallImgList = new ArrayList<String>();
	private List<String> bigImgList = new ArrayList<String>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeagnosticInfo() {
		return deagnosticInfo;
	}
	public void setDeagnosticInfo(String deagnosticInfo) {
		this.deagnosticInfo = deagnosticInfo;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public List<String> getSmallImgList() {
		return smallImgList;
	}
	public void setSmallImgList(List<String> smallImgList) {
		this.smallImgList = smallImgList;
	}
	public List<String> getBigImgList() {
		return bigImgList;
	}
	public void setBigImgList(List<String> bigImgList) {
		this.bigImgList = bigImgList;
	}
	
	
	
}
