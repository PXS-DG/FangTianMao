package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;

public class UserDeleteServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        User user = new User();
        user.setId((String) request.getSession().getAttribute("id"));
         
        new UserDAO().delete(user);
        if ("Œﬁ”√".equals(user.backnews)) {
        	response.sendRedirect("delete_fail.html");
        }  
        else {
        	response.sendRedirect("delete_success.html");
        }
       
          
        
        
    }
}