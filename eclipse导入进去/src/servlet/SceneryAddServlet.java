package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Scenery;
import dao.SceneryDAO;
 
public class SceneryAddServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Scenery scenery = new Scenery();
        scenery.setName(request.getParameter("name"));
        scenery.setTime(request.getParameter("time"));
        scenery.setNumber(request.getParameter("people"));
        scenery.setCompany(request.getParameter("company"));
         
        new SceneryDAO().add(scenery);
       
        if ("Œﬁ”√".equals(scenery.backnews)) {
        	response.sendRedirect("add_fail.html");
        }  
        else {
        	response.sendRedirect("add_success.html");
        }
       
       
    }
}