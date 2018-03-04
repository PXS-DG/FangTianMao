package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;

public class LoginServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        User user = new User();
        user.setId(request.getParameter("id"));
        
        user.setPW(request.getParameter("pw"));
        
        new UserDAO().login(user);
        if ("登录成功".equals(user.backnews)) {
        	request.getSession().setAttribute("userid", user.u_id);
        	request.getSession().setAttribute("username", user.u_name);
        	request.getSession().setAttribute("usersex", user.u_sex);
        	request.getSession().setAttribute("userheight", user.u_h);
        	request.getSession().setAttribute("userpw", user.u_pw);
        	request.getSession().setAttribute("userss", user.u_s);
        	
        	response.sendRedirect("USEALL.jsp");
        }
        else if("您输入的用户名不存在，或密码不般配".equals(user.backnews)){
            response.sendRedirect("fail.html");
        }  
        
        
    }
}
