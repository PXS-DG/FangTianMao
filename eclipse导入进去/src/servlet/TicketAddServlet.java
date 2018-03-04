package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Ticket;
import dao.TicketDAO;
 
public class TicketAddServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Ticket ticket = new Ticket();
        ticket.setCity(request.getParameter("city"));
        ticket.setPrice(request.getParameter("price"));
        ticket.setTime(request.getParameter("time"));
        ticket.setCompany(request.getParameter("company"));
         
        new TicketDAO().add(ticket);
       
        if ("Œﬁ”√".equals(ticket.backnews)) {
        	response.sendRedirect("add_fail.html");
        }  
        else {
        	response.sendRedirect("add_success.html");
        }
       
       
    }
}