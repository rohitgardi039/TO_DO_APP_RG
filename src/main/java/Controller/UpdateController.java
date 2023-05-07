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
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		String name=request.getParameter("name");
		String task=request.getParameter("task");
		String status=request.getParameter("status");
		
		app_bo_add ab=new app_bo_add();
		ab.setId(id);
		ab.setName(name);
		ab.setTask(task);
		ab.setStatus(status);
		App_dao_class.Update(ab);
	    response.sendRedirect("All_app_controller");
		     
		
		
	}

}
