import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
    
   


    
  }
  
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
    PrintWriter out = response.getWriter();
    String uname = request.getParameter("uname");
    String upass = request.getParameter("upass");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select uname,upass from user_reg where uname='"+uname+"' and upass='"+upass+"'");
      
      if(rs.next()) {
        response.sendRedirect("http://localhost:8081/simpleLogin/WelcomeUser.jsp?name="+rs.getString("uname"));
        HttpSession session = request.getSession();
        session.setAttribute("uname", uname);
        
        
      }else {
        out.println("Wrong id and password");
      }
      

      
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
  }
  
  
}