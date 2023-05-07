package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import bo.app_bo;
import dao.App_dao_class;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pass=request.getParameter("password");
		
		
	
		app_bo em=new app_bo();
		em.setName(name);
		em.setEmail(email);
		em.setPhone(phone);
		em.setPassword(pass);
		
		int status =App_dao_class.signup(em);
		if(status>0)
		{
			pw.print("Your data sucessfully save");
		}
		else
		{
			pw.print("<h1>Something Wrong!!!!</h1>");
		}
		
		
		
	}

}
