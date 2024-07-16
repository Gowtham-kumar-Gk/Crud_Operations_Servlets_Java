package crude.delete.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import crude.database.com.DatabaseConnection;
import java.sql.*;
/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	String id = request.getParameter("id");
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DatabaseConnection.getConnection();
    		Statement st = con.createStatement();
			st.executeUpdate("Delete from employees WHERE id = "+id+";");
			out.println("Record Deleted Successfully<br>");
    		
    	}
    	catch(Exception e)
    	{
    		out.println(e);
    	}
    	out.println("<br>");
    	out.println("<br>");
    	out.println("<a href = 'Index.html'>Back</a>");
    	
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
