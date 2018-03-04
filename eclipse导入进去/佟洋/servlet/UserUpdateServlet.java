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
        user.setId((String) request.getSession().getAttribute("userid"));
        user.setName(request.getParameter("name"));
       
        user.setH(Integer.parseInt(request.getParameter("height")));
        
         
        new UserDAO().update(user);
    	request.getSession().setAttribute("username", user.u_name);
    	
    	request.getSession().setAttribute("userheight", user.u_h);
            response.sendRedirect("USEALL.jsp");
          
        
        
    }
}
