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
        user.setPW(request.getParameter("pw"));
        user.setSex(request.getParameter("sex"));
        user.setH(Integer.parseInt(request.getParameter("height")));
        
         
        new UserDAO().add(user);
        if ("该用户已被使用".equals(user.backnews)) {
            request.getRequestDispatcher("aa.html").forward(request, response);
        }
        else{
            response.sendRedirect("success.html");
        }  
        
        
    }
}
