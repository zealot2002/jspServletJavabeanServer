package com.rain.javabean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rain.pojo.DoctorBO;
import com.rain.pojo.MedicalRecordBO;
import com.rain.util.DateAndTimeUtil;

public class DoctorBean {
	private static final String doctorStateArr[] = {"正常","未完善信息","未审核","已拒绝"};
	private static final String[] sexArr = {"女","男"};
	private static final String[] jobTitleArr = {"无","主任医师","副主任医师","主治医师","住院医师"};
	private static final String[] dutyArr = {"无","院长","副院长","主任","副主任"};
	
	
	
	
	public List<DoctorBO> getList() throws Exception {  
        DBAccess db = new DBAccess();  
 
        if(db.createConn()) {  
            String sql = "select * from t_doctor  order by signup_time desc";  
            ResultSet rs = db.queryAll(sql);
            List<DoctorBO> list = resultsetToVO(rs);
            db.closeRs();
            db.closeStm();  
            db.closeConn();  
            return list;  
        }  
        return null;
    } 
	
	private List resultsetToVO(ResultSet rs)
		      throws Exception{
		    List<DoctorBO> list=new ArrayList();
		    while(rs.next()){
		    	DoctorBO bo = new DoctorBO();
		    	bo.setId(rs.getInt("id")+"");
		    	bo.setName(rs.getString("user_name"));
		    	int sex = rs.getInt("sex");
		    	
		    	if(sex>1)
		    		sex = 1;
		    	bo.setSex(sexArr[sex]);
		    	bo.setHospital(new HospitalBean().getName(rs.getInt("hospital_has_department_hospital_id")+""));
		    	bo.setDepartment(new DepartmentBean().getName(rs.getInt("hospital_has_department_department_id")+""));
		    	int i = rs.getInt("job_title");
		    	if(i<5&&i>=0){
		    		bo.setJobTitle(jobTitleArr[i]);
		    	}else{
		    		bo.setJobTitle(jobTitleArr[0]);
		    	}
		    	int j = rs.getInt("social_title");
		    	if(j<5&&j>=0){
		    		bo.setJobDuty(dutyArr[j]);
		    	}else{
		    		bo.setJobDuty(dutyArr[0]);
		    	}
		    	bo.setExpertise(rs.getString("expertise"));
		    	bo.setPhone(rs.getString("login_name"));//should be mobile
		    	bo.setState(doctorStateArr[rs.getInt("status")]);
		    	bo.setBarCode(rs.getString("barcode"));
		    	java.sql.Timestamp time = rs.getTimestamp("signup_time");
		    	bo.setRegisterTime(DateAndTimeUtil.timestampToString(time));
		      list.add(bo);
		    }
		    return list;
	  }
	
	public String getName(String id) throws Exception {  
        DBAccess db = new DBAccess();  
        String name = null;
        if(db.createConn()) {  
            String sql = "select name from t_doctor where id = "+id;  
            ResultSet rs = db.queryAll(sql); 
            while(rs.next()){
            	name = (rs.getString("name"));
            	break;
            }
            db.closeRs();  
            db.closeStm();  
            db.closeConn();  
        }  
        return name;
    }
	
	public DoctorBO getObjById(String id){
		DBAccess db = new DBAccess();  
		DoctorBO bo = new DoctorBO();
		try {
			 if(db.createConn()) {  
		            String sql = "select * from t_doctor where id = "+id;  
		            ResultSet rs = db.queryAll(sql); 
		            while(rs.next()){
		            	bo.setId(rs.getInt("id")+"");
				    	bo.setName(rs.getString("user_name"));
				    	bo.setSex(sexArr[rs.getInt("sex")]);
				    	bo.setHospital(new HospitalBean().getName(rs.getInt("hospital_has_department_hospital_id")+""));
				    	bo.setDepartment(new DepartmentBean().getName(rs.getInt("hospital_has_department_department_id")+""));
				    	int i = rs.getInt("job_title");
				    	if(i<5&&i>=0){
				    		bo.setJobTitle(jobTitleArr[i]);
				    	}else{
				    		bo.setJobTitle(jobTitleArr[0]);
				    	}
				    	int j = rs.getInt("social_title");
				    	if(j<5&&j>=0){
				    		bo.setJobDuty(dutyArr[j]);
				    	}else{
				    		bo.setJobDuty(dutyArr[0]);
				    	}
				    	bo.setExpertise(rs.getString("expertise"));
				    	bo.setPhone(rs.getString("login_name"));//should be mobile
				    	bo.setState(doctorStateArr[rs.getInt("status")]);
				    	bo.setBarCode(rs.getString("barcode"));
				    	
				    	java.sql.Timestamp time = rs.getTimestamp("signup_time");
				    	bo.setRegisterTime(DateAndTimeUtil.timestampToString(time));
				    	
				    	getImgList(bo.getId(),bo);
				    	break;
		            }
		            db.closeRs();  
		            db.closeStm();  
		            db.closeConn();  
		        }  
		} catch (Exception e) {
			
		}
       return bo;
	}
	
	private void getImgList(String doctorId,DoctorBO bo){
		List<String> list = new ArrayList<String>();
		DBAccess db = new DBAccess();
		try {
			 if(db.createConn()) {  
		            String sql = "select * from t_certificate_doctor where doctor_id = "+doctorId;  
		            ResultSet rs = db.queryAll(sql); 
		            while(rs.next()){
		            	String smallImgUri = OSSSignature.getSignature(rs.getString("job_certificate"));//正面
		            	bo.getSmallImgList().add(smallImgUri);
		            	smallImgUri = OSSSignature.getSignature(rs.getString("occupation_certificate"));//背面
		            	bo.getSmallImgList().add(smallImgUri);
		            	
		            	bo.getBigImgList().add(rs.getString("job_certificate"));//正面
		            	bo.getBigImgList().add(rs.getString("occupation_certificate"));//背面
		            }
		            db.closeRs();
		            db.closeStm();
		            db.closeConn();
		        }
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
