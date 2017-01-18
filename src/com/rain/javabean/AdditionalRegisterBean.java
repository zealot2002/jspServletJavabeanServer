package com.rain.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rain.pojo.AdditionalRegisterBO;
import com.rain.pojo.DoctorBO;
import com.rain.pojo.PatientBO;
import com.rain.util.DateAndTimeUtil;

public class AdditionalRegisterBean {
	final String[] arrayState = {"无","未审核","审核未通过","审核已通过","医生同意","医生拒绝","医生取消","患者退号"};
	public List<AdditionalRegisterBO> getList(){
        DBAccess db = new DBAccess();  
		 try {
			 if(db.createConn()) {  
		         String sql = "select * from t_additional_register order by create_time desc";  
		         ResultSet rs = db.queryAll(sql); 
		         List<AdditionalRegisterBO> list = resultsetToVO(rs);
		         db.closeRs();  
		         db.closeStm();  
		         db.closeConn();  
		         return list;  
		     }  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<AdditionalRegisterBO>();
    } 
	
	private List<AdditionalRegisterBO> resultsetToVO(ResultSet rs)
		      throws Exception{
	    List<AdditionalRegisterBO> list=new ArrayList<AdditionalRegisterBO>();
	    while(rs.next()){
	    	AdditionalRegisterBO bo = new AdditionalRegisterBO();
	    	bo.setId(rs.getInt("id")+"");
        	
        	DoctorBO doctorBO = new DoctorBean().getObjById(rs.getInt("doctor_id")+"");
	    	bo.setDoctor(doctorBO.getName());
	    	bo.setDoctorPhone(doctorBO.getPhone());
	    	bo.setDoctorHospital(doctorBO.getHospital());
	    	bo.setDoctorDepartment(doctorBO.getDepartment());
	    	bo.setDoctorJobTitle(doctorBO.getJobTitle());
	    	
	    	PatientBO patientBO = new PatientBean().getObjById(rs.getInt("patient_id")+"");
	    	 
	    	bo.setPatient(patientBO.getName());
	    	bo.setPatientPhone(patientBO.getPhone());
	    	bo.setState(arrayState[rs.getInt("status")]);
	    	
	    	java.sql.Timestamp time = rs.getTimestamp("create_time");
	    	bo.setCreateTime(DateAndTimeUtil.timestampToString(time));
	    	
	    	bo.setMedicalRecordId(rs.getInt("medical_record_id")+"");
	        list.add(bo);
	    }
	    return list;
	}

	public AdditionalRegisterBO getObjById(String id){
		DBAccess db = new DBAccess();  
		AdditionalRegisterBO bo = new AdditionalRegisterBO();
		try {
			 if(db.createConn()) {  
		            String sql = "select * from t_additional_register where id = "+id;  
		            ResultSet rs = db.queryAll(sql); 
		            while(rs.next()){
		            	bo.setId(rs.getInt("id")+"");
		            	
		            	DoctorBO doctorBO = new DoctorBean().getObjById(rs.getInt("doctor_id")+"");
				    	bo.setDoctor(doctorBO.getName());
				    	bo.setDoctorPhone(doctorBO.getPhone());
				    	bo.setDoctorHospital(doctorBO.getHospital());
				    	bo.setDoctorDepartment(doctorBO.getDepartment());
				    	bo.setDoctorJobTitle(doctorBO.getJobTitle());
				    	
				    	PatientBO patientBO = new PatientBean().getObjById(rs.getInt("patient_id")+"");
				    	 
				    	bo.setPatient(patientBO.getName());
				    	bo.setPatientPhone(patientBO.getPhone());
				    	bo.setState(arrayState[rs.getInt("status")]);
				    	
				    	java.sql.Timestamp time = rs.getTimestamp("create_time");
				    	bo.setCreateTime(DateAndTimeUtil.timestampToString(time));
				    	bo.setMedicalRecordId(rs.getInt("medical_record_id")+"");
				    	break;
		            }

		            db.closeRs();  
		            db.closeStm();  
		            db.closeConn();  
		        }  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
}
