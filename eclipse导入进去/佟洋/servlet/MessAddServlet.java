package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Mess;
import dao.MessDAO;

public class MessAddServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
        String userid= (String) request.getSession().getAttribute("userid");
            if(userid==null){
            	response.sendRedirect("login.jsp");
        	}else{
        		Mess mess = new Mess();
                mess.setM_id(request.getParameter("mid"));
                mess.setU_id((String) request.getSession().getAttribute("userid"));
                mess.setM_t(request.getParameter("mt"));
                mess.setM_c(request.getParameter("mc"));
                
                
                 
                new MessDAO().add(mess);
                if ("¡Ù—‘ID±ª π”√".equals(mess.backnews)) {
                    request.getRequestDispatcher("mess.html").forward(request, response);
                }
                else{
                    response.sendRedirect("msuccess.html");
                }  
        	}
        
        
        
    }
}
