package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Mess;
import dao.MessDAO;
 
public class MessListServlete extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
         
        Mess mess = new Mess();
        mess.setM_id(request.getParameter("id"));
        
        new MessDAO().get(mess);
        if ("”–¡Ù—‘".equals(mess.backnews)) {
        	request.getSession().setAttribute("messuid", mess.u_id);
        	request.getSession().setAttribute("messid", mess.m_id);
        	request.getSession().setAttribute("messt", mess.m_t);
        	request.getSession().setAttribute("messc", mess.m_c);
        	
        	
        	request.getRequestDispatcher("DeleteMESS.jsp").forward(request, response);
        }
        else if("Œﬁ¡Ù—‘".equals(mess.backnews)){
            response.sendRedirect("slfail.html");
        }  
 
    }
}