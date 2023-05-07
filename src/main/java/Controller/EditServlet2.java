package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import bo.app_bo_add;
import dao.App_dao_class;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
          
	      int id1= Integer.parseInt(id);
	    
	      app_bo_add ab= App_dao_class.getappid(id1);
	 
		 
		pw.print("<form  action='UpdateController' method='Get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+ab.getId()+"'/></td></tr>");
	   	pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+ab.getName()+"'/></td></tr>");

	    pw.print("<tr><td>Task: </td> <td><input type='text' name='task' value='"+ab.getTask()+"'/></td></tr>");
	   	pw.print("<tr><td>Status:</td> <td><input type='text'  name='status' value='"+ab.getStatus()+"'/></td></tr>");
	    pw.print("<tr><td><input type='submit' value='Update '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
	}

}
