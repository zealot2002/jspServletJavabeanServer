package com.rain.javabean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rain.pojo.DoctorBO;
import com.rain.pojo.PatientBO;

public class DiseaseBean {
	
	public String getName(String id) throws Exception {  
        DBAccess db = new DBAccess();  
        String name = null;
        if(db.createConn()) {  
            String sql = "select name from t_disease where id = "+id;  
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
