package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import bean.Scenery;
import bean.User;

public class SceneryDAO {
	
    public SceneryDAO() {
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
  
    public void add(Scenery scenery) {
        String backnews ="";
        String sql = "insert into scenery values(?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, scenery.name);
            ps.setString(2, scenery.time);
            ps.setString(3, scenery.people);
            ps.setString(4, scenery.company);
  
            ps.execute();
  
        } catch (SQLException e) {
               backnews = "无用";
               
               scenery.setBacknews(backnews);
               
               
            e.printStackTrace();
        }
    }
    
    public void delete(Scenery scenery) {
     
            String sql = "delete from scenery where id =? " ;
			try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
                       ps.setString(1,scenery.id);
                       ps.execute();
    
            } catch (SQLException e) {
      
                e.printStackTrace();
          }
        }
    
    public void get(Scenery scenery) {
    	 String sql = "select * from scenery where name =?";
         String backnews="";
         try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
             ps.setString(1,scenery.name);
             java.sql.ResultSet rs=ps.executeQuery();
             boolean m=rs.next();
             if(m==true)
             {  backnews="有用";
             scenery.setBacknews(backnews);
             scenery.setName(rs.getString(2));
             scenery.setTime(rs.getString(3));
             scenery.setPeople(rs.getString(4));
             scenery.setCompany(rs.getString(5));
                              
             }
            else
             {  backnews="无用";
             scenery.setBacknews(backnews); 
             }
           }
                     
          catch (SQLException e) {
           e.printStackTrace();
         }
     }
    
    public void update(Scenery scenery) {
    	  
        String sql = "update scenery set name= ?, password = ? , telephone = ? where  = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, scenery.name);
            ps.setString(2, scenery.time);
            ps.setString(3, scenery.people);
            ps.setString(4, scenery.company);
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
    
    
      
}
