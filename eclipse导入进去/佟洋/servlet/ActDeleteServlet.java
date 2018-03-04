package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Act;
import dao.ActDAO;

public class ActDeleteServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Act act = new Act();
        act.setA_id((String) request.getSession().getAttribute("actid"));
         
        new ActDAO().delete(act);
        response.sendRedirect("SearchACT.jsp");
          
        
        
    }
}
