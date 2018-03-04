package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Mess;
import dao.MessDAO;

public class MessDeleteServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Mess mess = new Mess();
        mess.setM_id((String) request.getSession().getAttribute("messid"));
         
        new MessDAO().delete(mess);
        response.sendRedirect("SearchMESS.jsp");
          
        
        
    }
}
