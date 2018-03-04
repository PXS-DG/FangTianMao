package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;
 
public class UserListServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         
        User user = new User();
        user.setId(request.getParameter("id"));
        
        new UserDAO().get(user);
        if ("有用户".equals(user.backnews)) {
        	request.getSession().setAttribute("useid", user.u_id);
        	request.getSession().setAttribute("usename", user.u_name);
        	request.getSession().setAttribute("usesex", user.u_sex);
        	request.getSession().setAttribute("useheight", user.u_h);
        	request.getSession().setAttribute("uses", user.u_s);
        	
        	request.getRequestDispatcher("DeleteUSE.jsp").forward(request, response);
        }
        else if("无用户".equals(user.backnews)){
            response.sendRedirect("sufail.html");
        }  
 
    }
}