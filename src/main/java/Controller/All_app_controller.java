package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import bo.app_bo_add;
import dao.App_dao_class;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class All_app_controller
 */
@WebServlet("/All_app_controller")
public class All_app_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_app_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		   response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   pw.print("<link rel='stylesheet' href='css/table.css'>");
		   
		   pw.print("<a href='home.html'>Back</a>");
		   
		   pw.print("<table  border='1px' width='100%'> ");
		    
		    pw.print("<tr> <th> Id </th> <th> Name </th> <th> Task</th> <th> status</th> <th> actions</th></tr>");
		   
		   
		   
		  List<app_bo_add> list=App_dao_class.getAllApp();
		   
		  for( app_bo_add eb:list) {
			  
			   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getTask()+"</td><td>"+eb.getStatus()+"</td><td>"+"<a href='editservlet?id="+eb.getId()+"'> edit </a></td> <td><a href='DeleteServlet?id="+eb.getId()+"'> delete </a></td></tr>"); 
		  }
		   
		  pw.print("</table>");
	}

	}


