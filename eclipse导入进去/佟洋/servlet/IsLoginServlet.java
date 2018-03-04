package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IsLoginServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
        String userid= (String) request.getSession().getAttribute("userid");
            if(userid==null){
            	response.sendRedirect("login.jsp");
        	}else{
        		response.sendRedirect("USEALL.jsp");
                    }
        
        
        
    }
}
