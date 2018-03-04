package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Tic;
import dao.TicDAO;

public class TicDeleteServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Tic tic = new Tic();
        tic.setT_id((String) request.getSession().getAttribute("ticid"));
         
        new TicDAO().delete(tic);
        response.sendRedirect("SearchTIC.jsp");
          
        
        
    }
}
