package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import bo.app_bo_add;
import dao.App_dao_class;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class App_Controller
 */
@WebServlet("/App_Controller")
public class App_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public App_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String Name=request.getParameter("name");
		String task=request.getParameter("task");
		String status=request.getParameter("status");
		
		
		pw.print(task+" "+status);
		
		
		app_bo_add ab=new app_bo_add();
		ab.setTask(task);
		ab.setName(Name);
		
		ab.setStatus(status);
		
		
		int status1=App_dao_class.do_app(ab);
		
		
		if(status1>0) {
			
		  RequestDispatcher rd=request.getRequestDispatcher("All_app_controller");
		  rd.forward(request, response);
			
		
		
		}else {

		     RequestDispatcher rd=request.getRequestDispatcher("addapp.html");
			  rd.include(request, response);
			
		
	}


}
}
