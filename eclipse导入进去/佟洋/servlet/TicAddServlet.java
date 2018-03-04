package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Tic;
import dao.TicDAO;

public class TicAddServlet extends HttpServlet {
 
     protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
        String userid= (String) request.getSession().getAttribute("userid");
            if(userid==null){
            	response.sendRedirect("login.jsp");
        	}else{
        		Tic tic = new Tic();
        		
        		int a=Integer.parseInt(request.getParameter("height"));
        		if(a>=140)
        		{
        		tic.setT_id("tic"+(String) request.getSession().getAttribute("userid"));
                tic.setU_id((String) request.getSession().getAttribute("userid"));
                tic.setT_a("成人票");
                tic.setT_b(" ");
                }else{
                tic.setT_id("tic"+(String) request.getSession().getAttribute("userid"));
                tic.setU_id((String) request.getSession().getAttribute("userid"));
                tic.setT_a(" ");
                tic.setT_b("儿童票");
                }
        		
                new TicDAO().add(tic);
                if ("门票ID被使用".equals(tic.backnews)) {
                    request.getRequestDispatcher("tic.html").forward(request, response);
                }
                else{
                    response.sendRedirect("tsuccess.html");
                }  
        	}
        
        
        
    }
}
