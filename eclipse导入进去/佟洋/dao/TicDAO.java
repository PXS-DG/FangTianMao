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
import bean.Tic;
import bean.User;
   
public class TicDAO {
   
    public TicDAO() {
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
    
    public void add(Tic tic) {
    	   
        String sql = "insert into tic values(?,?,?,?)";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,tic.t_id);
            ps.setString(2, tic.u_id);
            ps.setString(3, tic.t_a);
            ps.setString(4, tic.t_b);
          
   
            ps.execute();
   
            
            
        } catch (SQLException e) {
        	 backnews="门票ID被使用";
        	 tic.setBacknews(backnews);
            
            
            		
            e.printStackTrace();
        }
    }
    
    
    public void get(Tic tic) {
   	   
        String sql = "select * from tic where t_id =?";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,tic.t_id);
            ResultSet rs=ps.executeQuery();
            boolean m=rs.next();
            if(m==true)
            {  backnews="有票";
            tic.setBacknews(backnews);
            tic.setU_id(rs.getString(2));
            tic.setT_a(rs.getString(3));
            tic.setT_b(rs.getString(4));
               
               
            }
           else
            {  backnews="无票";
            tic.setBacknews(backnews); 
            }
          }
          

   
            
            
         catch (SQLException e) {
        	 
        	
            
            
            		
            e.printStackTrace();
        }
    }
    
    public void delete(Tic tic) {
    	String sql = "delete from tic where t_id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,tic.t_id);
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
    }
//    public void get(Tic tic) {
//  	   
//        String sql = "select * from tic where u_id =?";
//        String backnews="";
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
//            ps.setString(1,tic.u_id);//改了uid
//            ResultSet rs=ps.executeQuery();
//            boolean m=rs.next();
//            if(m==true)
//            {  backnews="已购票";
//            
//               
//               
//            }
//           
//          }
//          
//
//   
//            
//            
//         catch (SQLException e) {
//        	 
//        	
//            
//            
//            		
//            e.printStackTrace();
//        }
//    }
//    
//    public void delete(Act act) {
//    	String sql = "delete from act where a_id = ?";
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
//            ps.setString(1,act.a_id);
//            ps.execute();
//   
//        } catch (SQLException e) {
//   
//            e.printStackTrace();
//        }
//    }
    
    
}