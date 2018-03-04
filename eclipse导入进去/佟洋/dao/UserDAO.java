package dao;
   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
  
import bean.User;
   
public class UserDAO {
   
    public UserDAO() {
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
   
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
   
            String sql = "select count(*) from user";
   
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
   
            System.out.println("total:" + total);
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
        return total;
    }
    
    public void login(User user) {
    	   
        String sql = "select * from h_user where u_id =? and u_pw =?";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,user.u_id);
            ps.setString(2, user.u_pw);
            ResultSet rs=ps.executeQuery();
            boolean m=rs.next();
            if(m==true)
            {  backnews="登录成功";
               user.setBN(backnews);
               user.setName(rs.getString(2));
               user.setSex(rs.getString(4));
               user.setH(rs.getInt(5));
               user.setS(rs.getInt(6));
            }
           else
            {  backnews="您输入的用户名不存在，或密码不般配";
               user.setBN(backnews); 
            }
          }
          

   
            
            
         catch (SQLException e) {
        	 
        	
            
            
            		
            e.printStackTrace();
        }
    }
   
    public void add(User user) {
   
        String sql = "insert into h_user values(?,?,?,?,?,null)";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,user.u_id);
            ps.setString(2, user.u_name);
            ps.setString(3, user.u_pw);
            ps.setString(4, user.u_sex);
            ps.setInt(5, user.u_h);
          
   
            ps.execute();
   
            
            
        } catch (SQLException e) {
        	 backnews="该用户已被使用";
        	user.setBN(backnews);
            
            
            		
            e.printStackTrace();
        }
    }
   
    public void update(User user) {
   
        String sql = "update h_user set u_name= ?,u_h = ? where u_id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
   
            ps.setString(1, user.u_name);
            ps.setInt(2, user.u_h);
            ps.setString(3, user.u_id);
   
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
   
    }
   
    public void promote(User user) {
    	   
        String sql = "update h_user set u_s= ? where u_id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
   
        	ps.setInt(1, 1);
            ps.setString(2, user.u_id);
   
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
   
    }
    
    public void updatepw(User user) {
    	   
        String sql = "update h_user set u_pw= ? where u_id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
   
            ps.setString(1, user.u_pw);
            ps.setString(2, user.u_id);
   
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
   
    }
    
    public void delete(User user) {
    	String sql = "delete from h_user where u_id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,user.u_id);
            ps.execute();
   
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
    }
    public void get(User user) {
 	   
        String sql = "select * from h_user where u_id =?";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,user.u_id);
            ResultSet rs=ps.executeQuery();
            boolean m=rs.next();
            if(m==true)
            {  backnews="有用户";
               user.setBN(backnews);
               user.setName(rs.getString(2));
               user.setSex(rs.getString(4));
               user.setH(rs.getInt(5));
               user.setS(rs.getInt(6));
            }
           else
            {  backnews="无用户";
               user.setBN(backnews); 
            }
          }
          

   
            
            
         catch (SQLException e) {
        	 
        	
            
            
            		
            e.printStackTrace();
        }
    }
    
   
    public List<User> list() {
        return list(0, Short.MAX_VALUE);
    }
   
    public List<User> list(int start, int count) {
        List<User> users = new ArrayList<User>();
   
        String sql = "select * from h_user order by id desc limit ?,? ";
   
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
   
            ps.setInt(1, start);
            ps.setInt(2, count);
   
            ResultSet rs = ps.executeQuery();
   
            while (rs.next()) {
                User user = new User();
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pw = rs.getString(3);
                String sex = rs.getString(4);
                int h = rs.getInt(5);
                int ss= rs.getInt(6);
                user.u_name = name;
                user.u_pw=pw;
                user.u_sex=sex;
                user.u_h=h;
                user.u_s=ss;
                user.u_id = id;
                users.add(user);
            }
        } catch (SQLException e) {
   
            e.printStackTrace();
        }
        return users;
    }
   
}