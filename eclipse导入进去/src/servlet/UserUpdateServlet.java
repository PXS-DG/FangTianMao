package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;

public class UserUpdateServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        User user = new User();
        user.setId((String) request.getSession().getAttribute("id"));
        user.setName(request.getParameter("name"));
        user.setPw(request.getParameter("Pw"));
        user.setTelephone(request.getParameter("Telephone"));
        
        new UserDAO().update(user);
    	request.getSession().setAttribute("name", user.name);
    	request.getSession().setAttribute("pw", user.pw);
    	request.getSession().setAttribute("telephone", user.telephone);
            response.sendRedirect("USEALL.jsp");
          
        
        
    }
}