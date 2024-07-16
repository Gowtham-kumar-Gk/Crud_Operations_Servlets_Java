package crude.update.com;

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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Update() {
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	String id = request.getParameter("id");
    	String email = request.getParameter("em");
    	String fname = request.getParameter("fnm");
    	String lname = request.getParameter("lnm");
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DatabaseConnection.getConnection();
    		PreparedStatement pst = con.prepareStatement("insert into employees values(?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, email);
			pst.setString(3, fname);
			pst.setString(4, lname);
			pst.executeUpdate();
			out.println("Details Successfully Updated in database");
			
			
    	}
    	catch(Exception e)
    	{
    		out.println(e);
    	}
    	out.println();
    	out.println();
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
