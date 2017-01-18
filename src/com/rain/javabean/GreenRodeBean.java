package com.rain.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rain.pojo.AdditionalRegisterBO;
import com.rain.pojo.DoctorBO;
import com.rain.pojo.GreenRodeBO;
import com.rain.pojo.PatientBO;
import com.rain.util.DateAndTimeUtil;

public class GreenRodeBean {
	final String[] stateArr = {"提交需求","确认需求","快速执行","结束"};
	
	public List getList(){
        DBAccess db = new DBAccess();  
		 try {
			 if(db.createConn()) {  
		         String sql = "select * from t_express_lane_service order by create_time desc";  
		         ResultSet rs = db.queryAll(sql); 
		         List<GreenRodeBO> list = resultsetToVO(rs);
		         db.closeRs();  
		         db.closeStm();  
		         db.closeConn();  
		         return list;  
		     }  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<GreenRodeBO>();
    } 
	
	private List<GreenRodeBO> resultsetToVO(ResultSet rs)
		      throws Exception{
	    List<GreenRodeBO> list=new ArrayList<GreenRodeBO>();
	    while(rs.next()){
	    	GreenRodeBO bo = new GreenRodeBO();
	    	bo.setId(rs.getInt("id")+"");
        	
	    	PatientBO patientBO = new PatientBean().getObjById(rs.getInt("patient_id")+"");
	    	 
	    	bo.setPatient(patientBO.getName());
	    	bo.setPatientPhone(patientBO.getPhone());
	    	bo.setNeedService(rs.getString("patient_note"));
	    	
	    	java.sql.Timestamp time = rs.getTimestamp("create_time");
	    	bo.setCreateTime(DateAndTimeUtil.timestampToString(time));
	    	bo.setState(stateArr[rs.getInt("status")]);
	    	
	        list.add(bo);
	    }
	    return list;
	}

	public GreenRodeBO getObjById(String id){
		DBAccess db = new DBAccess();  
		GreenRodeBO bo = new GreenRodeBO();
		try {
			 if(db.createConn()) {  
		            String sql = "select * from t_express_lane_service where id = "+id;  
		            ResultSet rs = db.queryAll(sql); 
		            while(rs.next()){
		            	bo.setId(rs.getInt("id")+"");
		            	
				    	PatientBO patientBO = new PatientBean().getObjById(rs.getInt("patient_id")+"");
				    	
				    	bo.setPatient(patientBO.getName());
				    	bo.setPatientPhone(patientBO.getPhone());
				    	bo.setNeedService(rs.getString("patient_note"));
				    	
				    	java.sql.Timestamp time = rs.getTimestamp("create_time");
				    	bo.setCreateTime(DateAndTimeUtil.timestampToString(time));
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
