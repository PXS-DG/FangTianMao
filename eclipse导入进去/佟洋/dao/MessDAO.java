package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
import bean.Mess;
import bean.User;
   
public class MessDAO {
   
    public MessDAO() {
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
    
    public void add(Mess mess) {
    	   
        String sql = "insert into mess values(?,?,?,?)";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,mess.m_id);
            ps.setString(2, mess.u_id);
            ps.setString(3, mess.m_t);
            ps.setString(4, mess.m_c);
          
   
            ps.execute();
   
            
            
        } catch (SQLException e) {
        	 backnews="留言ID被使用";
        	mess.setBacknews(backnews);
            
            
            		
            e.printStackTrace();
        }
    }
    
    public void get(Mess mess) {
  	   
        String sql = "select * from mess where m_id =?";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,mess.m_id);
            ResultSet rs=ps.executeQuery();
            boolean m=rs.next();
            if(m==true)
            {  backnews="有留言";
               mess.setBacknews(backnews);
               mess.setU_id(rs.getString(2));
               mess.setM_t(rs.getString(3));
               mess.setM_c(rs.getString(4));
               
               
            }
           else
            {  backnews="无留言";
               mess.setBacknews(backnews); 
            }
          }
          

   
            
            
         catch (SQLException e) {
        	 
        	
            
            
            		
            e.printStackTrace();
        }
    }
    
    public void delete(Mess mess) {
    	String sql = "delete from mess where m_id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,mess.m_id);
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
    }
    
    
}