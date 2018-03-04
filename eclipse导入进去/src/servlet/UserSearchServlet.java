package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;
 
public class UserSearchServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         
        User user = new User();
        user.setId(request.getParameter("id"));
        
        new UserDAO().get(user);
        if ("有用".equals(user.backnews)) {
        	request.getSession().setAttribute("id", user.id);
        	request.getSession().setAttribute("name", user.name);
        	request.getSession().setAttribute("pw", user.pw);
        	request.getSession().setAttribute("telephone", user.telephone);
        	
        	request.getRequestDispatcher("search_success.html").forward(request, response);
        }
        else if("无用".equals(user.backnews)){
            response.sendRedirect("search_fail.html");
        }  
 
    }
}