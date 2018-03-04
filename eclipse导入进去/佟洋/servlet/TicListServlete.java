package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Tic;
import dao.TicDAO;
 
public class TicListServlete extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         
        Tic tic = new Tic();
        tic.setT_id(request.getParameter("id"));
        
        new TicDAO().get(tic);
        if ("ÓÐÆ±".equals(tic.backnews)) {
        	request.getSession().setAttribute("ticuid", tic.u_id);
        	request.getSession().setAttribute("ticid", tic.t_id);
        	request.getSession().setAttribute("tica", tic.t_a);
        	request.getSession().setAttribute("ticb", tic.t_b);
        	
        	
        	request.getRequestDispatcher("DeleteTIC.jsp").forward(request, response);
        }
        else if("ÎÞÆ±".equals(tic.backnews)){
            response.sendRedirect("spfail.html");
        }  
 
    }
}