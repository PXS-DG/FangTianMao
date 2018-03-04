package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Scenery;
import dao.SceneryDAO;
 
public class ScenerySearchServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         
        Scenery scenery = new Scenery();
        scenery.setName(request.getParameter("name"));
        

		new SceneryDAO().get(scenery);
        if ("有用".equals(scenery.backnews)) {
        	request.getSession().setAttribute("name", scenery.name);
        	request.getSession().setAttribute("time", scenery.time);
        	request.getSession().setAttribute("people", scenery.people);
        	request.getSession().setAttribute("company", scenery.company);
        	
        	request.getRequestDispatcher("search_success.html").forward(request, response);
        }
        else if("无用".equals(scenery.backnews)){
            response.sendRedirect("search_fail.html");
        }  
 
    }
}