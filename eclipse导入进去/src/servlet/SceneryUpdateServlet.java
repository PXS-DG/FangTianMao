package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Scenery;
import dao.SceneryDAO;

public class SceneryUpdateServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Scenery scenery = new Scenery();
        scenery.setName(request.getParameter("name"));
        scenery.setTime(request.getParameter("Time"));
        scenery.setPeople(request.getParameter("people"));
        scenery.setCompany(request.getParameter("Company"));
        
        new SceneryDAO().update(scenery);
    	request.getSession().setAttribute("name", scenery.name);
    	request.getSession().setAttribute("people", scenery.people);
    	request.getSession().setAttribute("time", scenery.time);
    	request.getSession().setAttribute("company", scenery.company);
         response.sendRedirect("USEALL.jsp");
          
        
        
    }
}