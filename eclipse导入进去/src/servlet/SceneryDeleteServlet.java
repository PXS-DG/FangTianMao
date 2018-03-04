package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Scenery;
import dao.SceneryDAO;
 
public class SceneryDeleteServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Scenery scenery = new Scenery();
        scenery.setId((String) request.getSession().getAttribute("name"));
         
        new SceneryDAO().delete(scenery);
       
        if ("Œﬁ”√".equals(scenery.backnews)) {
        	response.sendRedirect("delete_fail.html");
        }  
        else {
        	response.sendRedirect("delete_success.html");
        }
       
       
    }
}