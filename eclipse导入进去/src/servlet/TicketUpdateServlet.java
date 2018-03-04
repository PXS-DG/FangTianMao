package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Ticket;
import dao.TicketDAO;

public class TicketUpdateServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Ticket ticket = new Ticket();
        ticket.setCity(request.getParameter("city"));
        ticket.setTime(request.getParameter("Time"));
        ticket.setPrice(request.getParameter("price"));
        ticket.setCompany(request.getParameter("Company"));
        
        new TicketDAO().update(ticket);
    	request.getSession().setAttribute("city", ticket.city);
    	request.getSession().setAttribute("price", ticket.price);
    	request.getSession().setAttribute("time", ticket.time);
    	request.getSession().setAttribute("company", ticket.company);
         response.sendRedirect("USEALL.jsp");
          
        
        
    }
}