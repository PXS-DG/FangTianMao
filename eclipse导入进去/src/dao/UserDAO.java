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
  
  
    public void get(User user) {
   	   
        String sql = "select * from user where id =?";
        String backnews="";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,user.id);
            ResultSet rs=ps.executeQuery();
            boolean m=rs.next();
            if(m==true)
            {  backnews="有用";
               user.setBacknews(backnews);
               user.setId(rs.getString(2));
               user.setName(rs.getString(3));
               user.setPw(rs.getString(4)); 
               user.setTelephone(rs.getString(5));
            }
           else
            {  backnews="无用";
               user.setBacknews(backnews); 
            }
          }          
         catch (SQLException e) {       	 
          e.printStackTrace();
        }
    }
    
    
    
  
    public void add(User user) {
        String backnews ="";
        String sql = "insert into users values(?,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, user.id);
            ps.setString(2, user.name);
            ps.setString(3, user.pw);
            ps.setString(4, user.telephone);
  
            ps.execute();
  
        } catch (SQLException e) {
               backnews = "无用";
               
               user.setBacknews(backnews);
               
               
            e.printStackTrace();
        }
    }
  
    public void update(User user) {
  
        String sql = "update user set name= ?, password = ? , telephone = ? where id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, user.name);
            ps.setString(2, user.pw);
            ps.setString(3, user.telephone);
            ps.setString(4, user.id);
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
 
   public void delete(User user) {
	   
	   String sql = "delete from users where id = ?";
        try (Connection c = getConnection(); PreparedStatement  ps = c.prepareStatement (sql);) {
                ps.setString(1,user.id);
                ps.execute();
  
        } catch (SQLException e) {
 
           e.printStackTrace();
      }
    }
//  
//    public Hero get(int id) {
//        Hero hero = null;
//  
//        try (Connection c = getConnection(); Statement s = c.createStatement();) {
//  
//            String sql = "select * from hero where id = " + id;
//  
//            ResultSet rs = s.executeQuery(sql);
//  
//            if (rs.next()) {
//                hero = new Hero();
//                String name = rs.getString(2);
//                float hp = rs.getFloat("hp");
//                int damage = rs.getInt(4);
//                hero.name = name;
//                hero.hp = hp;
//                hero.damage = damage;
//                hero.id = id;
//            }
//  
//        } catch (SQLException e) {
//  
//            e.printStackTrace();
//        }
//        return hero;
//    }
//  
//    public List<Hero> list() {
//        return list(0, Short.MAX_VALUE);
//    }
//  
//    public List<Hero> list(int start, int count) {
//        List<Hero> heros = new ArrayList<Hero>();
//  
//        String sql = "select * from hero order by id desc limit ?,? ";
//  
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
//  
//            ps.setInt(1, start);
//            ps.setInt(2, count);
//  
//            ResultSet rs = ps.executeQuery();
//  
//            while (rs.next()) {
//                Hero hero = new Hero();
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                float hp = rs.getFloat("hp");
//                int damage = rs.getInt(4);
//                hero.id = id;
//                hero.name = name;
//                hero.hp = hp;
//                hero.damage = damage;
//                heros.add(hero);
//            }
//        } catch (SQLException e) {
//  
//            e.printStackTrace();
//        }
//        return heros;
//    }
  
}