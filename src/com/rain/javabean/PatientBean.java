package com.rain.javabean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rain.pojo.DoctorBO;
import com.rain.pojo.PatientBO;
import com.rain.util.DateAndTimeUtil;

public class PatientBean {
	final String[] sexArr = {"Ů","��"};
	public List<PatientBO> getList(){  
        DBAccess db = new DBAccess();  
		 try {
			 if(db.createConn()) {  
		         String sql = "select * from t_patient order by signup_time desc";  
		         ResultSet rs = db.queryAll(sql); 
		         List<PatientBO> list = resultsetToVO(rs);
		         db.closeRs();  
		         db.closeStm();  
		         db.closeConn();  
		         return list;  
		     }  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<PatientBO>();
	}
	
	private List<PatientBO> resultsetToVO(ResultSet rs)
		      throws Exception{
		    List<PatientBO> list=new ArrayList<PatientBO>();
		    while(rs.next()){
		    	PatientBO bo = new PatientBO();
		    	bo.setId(rs.getInt("id")+"");
		    	bo.setName(rs.getString("name"));
		    	bo.setPhone(rs.getString("login_name"));//should be mobile
		    	bo.setIdCard(rs.getString("id_card"));
		    	bo.setCity(new CityBean().getName(rs.getInt("id")+""));
		    	java.sql.Timestamp time = rs.getTimestamp("signup_time");
		    	bo.setRegisterTime(DateAndTimeUtil.timestampToString(time));
		        list.add(bo);
		    }
		    return list;
	}

	public PatientBO getObjById(String id){
		DBAccess db = new DBAccess();  
		PatientBO bo = new PatientBO();
		try {
			 if(db.createConn()) {  
		            String sql = "select * from t_patient where id = "+id;  
		            ResultSet rs = db.queryAll(sql); 
		            while(rs.next()){
		            	bo.setName(rs.getString("name"));
				    	bo.setSex(sexArr[rs.getInt("sex")]);
				    	
				    	java.sql.Timestamp birthday = rs.getTimestamp("birthday");
				    	bo.setBirthday(DateAndTimeUtil.timestampToString(birthday));
				    	
				    	bo.setProvince(rs.getString("province_name"));
				    	bo.setCity(new CityBean().getName(rs.getInt("id")+""));

				    	bo.setIdCard(rs.getString("id_card"));
				    	bo.setPhone(rs.getString("login_name"));//should be mobile
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
	
	public String getName(String id) throws Exception {
        DBAccess db = new DBAccess();  
        String name = null;
        if(db.createConn()) {  
            String sql = "select name from t_patient where id = "+id;  
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
}
