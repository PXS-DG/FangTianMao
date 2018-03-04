package servlet;
import bean.*;
import com.sun.rowset.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MessListServlet extends HttpServlet
{  CachedRowSetImpl rowSet=null;
   public void init(ServletConfig config) throws ServletException
    { super.init(config);
      try {  Class.forName("com.mysql.jdbc.Driver");
          }
       catch(Exception e){} 
    }
   public  void  doPost(HttpServletRequest request,HttpServletResponse response) 
                        throws ServletException,IOException
  {    HttpSession session=request.getSession(true); 
       //Login login=(Login)session.getAttribute("login"); //获取用户登录时的Javabean
       boolean ok=true; 
       //if(login==null)
       //{ ok=false; 
       //  response.sendRedirect("login.jsp");             //重定向到登录页面
       //}
       if(ok==true)
       {  continueDoPost(request,response);
       }
   }
   public void continueDoPost(HttpServletRequest request,HttpServletResponse response)
                            throws ServletException,IOException  
   {    HttpSession session=request.getSession(true); 
        Connection con=null; 
        StringBuffer presentPageResult=new StringBuffer();
        ShowByPage showBean=null;
        try{  showBean=(ShowByPage)session.getAttribute("show");
              if(showBean==null)
             { showBean=new ShowByPage();  //创建Javabean对象
                session.setAttribute("show",showBean);
              }
           }
        catch(Exception exp)
           {  showBean=new ShowByPage();  
              session.setAttribute("show",showBean);
           } 
        showBean.setPageSize(3);  //每页显示5条记录
        int showPage=Integer.parseInt(request.getParameter("showPage"));
        if(showPage>showBean.getPageAllCount())
          showPage=1;
        if(showPage<=0)
          showPage=showBean.getPageAllCount();
        showBean.setShowPage(showPage);  
        int pageSize=showBean.getPageSize();
        String uri="jdbc:mysql://localhost:3306/test";
        try{ con=DriverManager.getConnection(uri,"root","admin");
             Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY);
             ResultSet rs=sql.executeQuery("SELECT * FROM mess");
             rowSet=new CachedRowSetImpl();  //创建行集对象
             rowSet.populate(rs);
             con.close();                     //关闭连接
             showBean.setRowSet(rowSet);  //数据存储在showBean中
             rowSet.last();
             int m=rowSet.getRow();           //总行数
             int n=pageSize;
             int pageAllCount=((m%n)==0)?(m/n):(m/n+1);
             showBean.setPageAllCount(pageAllCount);//数据存储在showBean中 
             presentPageResult=show(showPage,pageSize,rowSet);
             showBean.setPresentPageResult(presentPageResult); 
           }
        catch(SQLException exp){}
        RequestDispatcher dispatcher= 
request.getRequestDispatcher("MESSShow.jsp");//转发
        dispatcher.forward(request, response); 
    } 
   public StringBuffer show(int page,int pageSize,CachedRowSetImpl rowSet)
   {  StringBuffer str=new StringBuffer();
      try{ rowSet.absolute((page-1)*pageSize+1);
           for(int i=1;i<=pageSize;i++)
           { str.append("<tr>");
             str.append("<td>"+rowSet.getString(1)+"</td>"); 
             str.append("<td>"+rowSet.getString(2)+"</td>");
             str.append("<td>"+rowSet.getString(3)+"</td>");
             str.append("<td>"+rowSet.getString(4)+"</td>");
             str.append("</tr>");
             rowSet.next();  
            }
          }
      catch(SQLException exp){}
      return str;
   }
// public  void  doGet(HttpServletRequest request,HttpServletResponse response) 
//                       throws ServletException,IOException
// {    HttpSession session=request.getSession(true); 
//      Login login=(Login)session.getAttribute("login"); //获取用户登录时的Javabean
//      boolean ok=true; 
//      if(login==null)
//      { ok=false; 
//        response.sendRedirect("login.jsp");             //重定向到登录页面
//      }
//      if(ok==true)
//      {  continueDoGet(request,response);
//      }
//  }
//  public  void  continueDoGet(HttpServletRequest request,HttpServletResponse response) 
//                       throws ServletException,IOException
//   {   Field field=new Field();
//       request.setAttribute("inform",field);
//       String fieldname=request.getParameter("fieldname");
//       Connection con=null; 
//       String uri="jdbc:mysql://localhost:3306/test";
//       try{ con=DriverManager.getConnection(uri,"root","zteict"); 
//            Statement sql=con.createStatement(); 
//            ResultSet rs=sql.executeQuery("SELECT * FROM field where fieldname = '"+fieldname+"'");
//            if(rs.next())
//            {  field.setFieldid(rs.getString(1));
//            field.setFieldname(rs.getString(2));
//            field.setNumber(rs.getString(3));
//            field.setPrice(rs.getString(4));
//            field.setBackNews("查询到的场地信息：");
//            }
//            con.close();
//            RequestDispatcher dispatcher=
//request.getRequestDispatcher("showField.jsp");//转发
//            dispatcher.forward(request, response); 
//           }
//        catch(SQLException exp)
//           {  field.setBackNews(""+exp);System.out.println("ok1"+exp);
//           }  
//  }
}
