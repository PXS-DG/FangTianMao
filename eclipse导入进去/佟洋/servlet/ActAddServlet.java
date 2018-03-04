package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Act;
import dao.ActDAO;

public class ActAddServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
        
            
        		Act act = new Act();
        		act.setA_id(request.getParameter("aid"));
        		act.setU_id((String) request.getSession().getAttribute("userid"));
        		act.setA_t(request.getParameter("at"));
        		act.setA_c(request.getParameter("ac"));
                
                
                 
                new ActDAO().add(act);
                if ("活动ID被使用".equals(act.backnews)) {
                    request.getRequestDispatcher("act.html").forward(request, response);
                }
                else{
                    response.sendRedirect("asuccess.html");
                }  
        	}
        
        
        
    }

