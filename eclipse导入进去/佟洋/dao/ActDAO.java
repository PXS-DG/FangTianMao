package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
import bean.Act;
import bean.User;
   
public class ActDAO {
   
    public ActDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
   
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root",
                "admin");
    }
    
    public void add(Act act) {
    	   
        String sql = "insert into act values(?,?,?,?)";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,act.a_id);
            ps.setString(2, act.u_id);
            ps.setString(3, act.a_t);
            ps.setString(4, act.a_c);
          
   
            ps.execute();
   
            
            
        } catch (SQLException e) {
        	 backnews="活动ID被使用";
        	 act.setBacknews(backnews);
            
            
            		
            e.printStackTrace();
        }
    }
    
    public void get(Act act) {
  	   
        String sql = "select * from act where a_id =?";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,act.a_id);
            ResultSet rs=ps.executeQuery();
            boolean m=rs.next();
            if(m==true)
            {  backnews="有活动";
            act.setBacknews(backnews);
            act.setU_id(rs.getString(2));
            act.setA_t(rs.getString(3));
            act.setA_c(rs.getString(4));
               
               
            }
           else
            {  backnews="无活动";
            act.setBacknews(backnews); 
            }
          }
          

   
            
            
         catch (SQLException e) {
        	 
        	
            
            
            		
            e.printStackTrace();
        }
    }
    
    public void delete(Act act) {
    	String sql = "delete from act where a_id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,act.a_id);
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
    }
    
    
}