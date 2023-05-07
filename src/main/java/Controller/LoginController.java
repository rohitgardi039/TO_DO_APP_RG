package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.App_dao_class;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String email=request.getParameter("username");
		String pass=request.getParameter("password");
		
		if(App_dao_class.userLogin(email, pass)) {
			
		RequestDispatcher rd=request.getRequestDispatcher("home.html");
		rd.forward(request, response);
		}else {
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.include(request, response);
		}
		
	}

}
