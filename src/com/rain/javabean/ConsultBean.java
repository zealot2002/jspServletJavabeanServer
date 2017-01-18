package com.rain.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rain.pojo.ConsultBO;
import com.rain.pojo.ConsultBO;
import com.rain.pojo.DoctorBO;
import com.rain.pojo.PatientBO;
import com.rain.util.DateAndTimeUtil;

public class ConsultBean {
	final String[] arrayState = {"已通过","待审核","已拒绝"};
	private static final int DOCTOR = 0;
	private static final int PATIENT = 1;
	
	public List<ConsultBO> getList(){
        DBAccess db = new DBAccess();  
		 try {
			 if(db.createConn()) {  
		         String sql = "select * from t_friend_0 order by create_time desc";  
		         ResultSet rs = db.queryAll(sql); 
		         List<ConsultBO> list = resultsetToVO(rs);
		         db.closeRs();  
		         db.closeStm();  
		         db.closeConn();  
		         return list;  
		     }  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<ConsultBO>();
    } 
	
	private List<ConsultBO> resultsetToVO(ResultSet rs)
		      throws Exception{
		    List<ConsultBO> list=new ArrayList<ConsultBO>();
		    while(rs.next()){
		    	ConsultBO bo = new ConsultBO();
		    	bo.setId(rs.getInt("id")+"");
		    	
		    	int firstPersonType = rs.getInt("user1_type"); 
		    	if(PATIENT == firstPersonType){
		    		PatientBO patientBO = new PatientBean().getObjById(rs.getInt("user1_id")+"");
		    		bo.setFirstPersonName(patientBO.getName());
			    	bo.setFirstPersonPhone(patientBO.getPhone());
		    	}else{
		    		DoctorBO doctorBO = new DoctorBean().getObjById(rs.getInt("user1_id")+"");
		    		bo.setFirstPersonName(doctorBO.getName());
			    	bo.setFirstPersonPhone(doctorBO.getPhone());
		    	}

		    	int secondPersonType = rs.getInt("user2_type"); 
		    	if(PATIENT == secondPersonType){
		    		PatientBO patientBO = new PatientBean().getObjById(rs.getInt("user2_id")+"");
		    		bo.setSecondPersonName(patientBO.getName());
			    	bo.setSecondPersonPhone(patientBO.getPhone());
		    	}else{
		    		DoctorBO doctorBO = new DoctorBean().getObjById(rs.getInt("user2_id")+"");
		    		bo.setSecondPersonName(doctorBO.getName());
			    	bo.setSecondPersonPhone(doctorBO.getPhone());
		    	}
		    	
		    	bo.setState(arrayState[rs.getInt("status")]);
		    	
		    	java.sql.Timestamp time = rs.getTimestamp("create_time");
		    	bo.setCreateTime(DateAndTimeUtil.timestampToString(time));
		    	
		    	
		        list.add(bo);
		    }
		    return list;
	}

	public ConsultBO getObjById(String id){
		DBAccess db = new DBAccess();  
		ConsultBO bo = new ConsultBO();
		try {
			 if(db.createConn()) {  
		            String sql = "select * from t_additional_register where id = "+id;  
		            ResultSet rs = db.queryAll(sql); 
		            while(rs.next()){
		            	bo.setId(rs.getInt("id")+"");
				    	
				    	int firstPersonType = rs.getInt("user1_type"); 
				    	if(PATIENT == firstPersonType){
				    		PatientBO patientBO = new PatientBean().getObjById(rs.getInt("user1_id")+"");
				    		bo.setFirstPersonName(patientBO.getName());
					    	bo.setFirstPersonPhone(patientBO.getPhone());
				    	}else{
				    		DoctorBO doctorBO = new DoctorBean().getObjById(rs.getInt("user1_id")+"");
				    		bo.setFirstPersonName(doctorBO.getName());
					    	bo.setFirstPersonPhone(doctorBO.getPhone());
				    	}

				    	int secondPersonType = rs.getInt("user2_type"); 
				    	if(PATIENT == secondPersonType){
				    		PatientBO patientBO = new PatientBean().getObjById(rs.getInt("user2_id")+"");
				    		bo.setSecondPersonName(patientBO.getName());
					    	bo.setSecondPersonPhone(patientBO.getPhone());
				    	}else{
				    		DoctorBO doctorBO = new DoctorBean().getObjById(rs.getInt("user2_id")+"");
				    		bo.setSecondPersonName(doctorBO.getName());
					    	bo.setSecondPersonPhone(doctorBO.getPhone());
				    	}
				    	
				    	bo.setState(arrayState[rs.getInt("status")]);
				    	
				    	java.sql.Timestamp time = rs.getTimestamp("create_time");
				    	bo.setCreateTime(time.toString());
				    	
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
