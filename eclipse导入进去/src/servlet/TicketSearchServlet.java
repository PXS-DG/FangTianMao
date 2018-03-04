package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Ticket;
import dao.TicketDAO;
 
public class TicketSearchServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         
        Ticket ticket = new Ticket();
        ticket.setCity(request.getParameter("city"));
        
        new TicketDAO().get(ticket);
        if ("有用".equals(ticket.backnews)) {
        	request.getSession().setAttribute("city", ticket.city);
        	request.getSession().setAttribute("time", ticket.time);
        	request.getSession().setAttribute("price", ticket.price);
        	request.getSession().setAttribute("company", ticket.company);
        	
        	request.getRequestDispatcher("search_success.html").forward(request, response);
        }
        else if("无用".equals(ticket.backnews)){
            response.sendRedirect("search_fail.html");
        }  
 
    }
}