package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ticket;
import bean.User;
import dao.SceneryDAO;
import dao.TicketDAO;
import dao.UserDAO;

public class TicketDeleteServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Ticket ticket = new Ticket();
        ticket.setId((String) request.getSession().getAttribute("city"));
         
        new TicketDAO().delete(ticket);
       
        if ("Œﬁ”√".equals(ticket.backnews)) {
        	response.sendRedirect("delete_fail.html");
        }  
        else {
        	response.sendRedirect("delete_success.html");
        }
}
}