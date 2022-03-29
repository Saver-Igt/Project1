package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
    	
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	
    	String serverName = "DESKTOP-UGB9IJG";
		String dataBaseName = "Users";
		String user = "sa";
		String pass = "123";
		
		if (login.equals("123") && password.equals("123")) {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}else {
			PrintWriter printWriter = response.getWriter();
			printWriter.print("Sorry UserName or Password Error!");  
	        RequestDispatcher rd = request.getRequestDispatcher("/start.jsp");  
	        rd.include(request, response);  
		} 
	
    	
	}
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    	request.setCharacterEncoding("UTF-8");
	    	response.setContentType("text/html;charset=utf-8");	
	    	 
	 }

}
