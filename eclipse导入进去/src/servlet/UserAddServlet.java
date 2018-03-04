package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;
 
public class UserAddServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        User user = new User();
        user.setId(request.getParameter("id"));
        user.setName(request.getParameter("name"));
        user.setPw(request.getParameter("password"));
        user.setTelephone(request.getParameter("telephone"));
         
        new UserDAO().add(user);
       
        if ("Œﬁ”√".equals(user.backnews)) {
        	response.sendRedirect("add_fail.html");
        }  
        else {
        	response.sendRedirect("add_success.html");
        }
       
       
    }
}