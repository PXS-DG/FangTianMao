package dao;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import bean.Ticket;
  
public class TicketDAO {
  
    public TicketDAO() {
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
  
    public void get(Ticket ticket) {
    	  String sql = "select * from ticket where city =?";
          String backnews="";
          try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
              ps.setString(1,ticket.city);
              ResultSet rs=ps.executeQuery();
              boolean m=rs.next();
              if(m==true)
              {  backnews="有用";
              ticket.setBacknews(backnews);
              ticket.setTime(rs.getString(2));
              ticket.setPrice(rs.getString(3)); 
              ticket.setCompany(rs.getString(4));
              }
             else
              {  backnews="无用";
              ticket.setBacknews(backnews); 
              }
            }          
           catch (SQLException e) {       	 
            e.printStackTrace();
          }
      }
      
    
    
    
  
    public void add(Ticket ticket) {
        String backnews ="";
        String sql = "insert into ticket values(?,?,?.?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) { 
            ps.setString(1, ticket.city);
            ps.setString(2, ticket.time);
            ps.setString(3, ticket.price);
            ps.setString(4, ticket.company);
  
            ps.execute();
  
        } catch (SQLException e) {
               backnews = "无用";
               
               ticket.setBacknews(backnews);
               
               
            e.printStackTrace();
        }
    }
  
    public void update(Ticket ticket) {
  
       String sql = "update ticket set city= ?, time = ? , price = ? where  = ?";
       try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, ticket.city);
            ps.setString(2, ticket.price);
            ps.setString(3, ticket.company);
            ps.setString(4, ticket.time);
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
       }
 
    }
  
   public void delete(Ticket ticket) {
 
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
 
           String sql = "delete from ticket where name = ?" ;

            s.execute(sql);
  
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