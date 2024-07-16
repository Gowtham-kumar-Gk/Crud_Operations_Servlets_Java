package crude.read.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import crude.database.com.DatabaseConnection;
/**
 * Servlet implementation class Read
 */
@WebServlet("/Read")
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Read() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	String table = request.getParameter("table");
    	
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DatabaseConnection.getConnection();
    		Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+table);
			while(rs.next())
			{
				out.println("Id : "+rs.getInt(1)+"<br>");
				out.println("Email : "+rs.getString(2)+"<br>");
				out.println("First Name : "+rs.getString(3)+"<br>");
				out.println("Last Name : "+rs.getString(4)+"<br>");
				out.println("<br>");
				out.println("<br");
			}
    		
    	}
    	catch(Exception e)
    	{
    		out.println(e);
    	}
    	
    	out.println("<br>");
    	out.println("<br>");
    	out.println("<br><a href = 'Index.html'>Back</a>");
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
	}

}
