package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Act;
import dao.ActDAO;
 
public class ActListServlete extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         
        Act act = new Act();
        act.setA_id(request.getParameter("id"));
        
        new ActDAO().get(act);
        if ("有活动".equals(act.backnews)) {
        	request.getSession().setAttribute("actuid", act.u_id);
        	request.getSession().setAttribute("actid", act.a_id);
        	request.getSession().setAttribute("actt", act.a_t);
        	request.getSession().setAttribute("actc", act.a_c);
        	
        	
        	request.getRequestDispatcher("DeleteACT.jsp").forward(request, response);
        }
        else if("无活动".equals(act.backnews)){
            response.sendRedirect("smfail.html");
        }  
 
    }
}