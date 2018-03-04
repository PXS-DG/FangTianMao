package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ManageServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
        String userid= (String) request.getSession().getAttribute("userid");
            if(userid==null){
            	response.sendRedirect("login.jsp");
        	}else{
        		int a=Integer.parseInt(request.getParameter("s"));
        		if(a!=1)
        		{response.sendRedirect("mfail.html");
        		
                }else{
                	response.sendRedirect("Manage.html");
        	}
        
        
        
    }
     }}
