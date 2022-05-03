package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.User;

@WebServlet("/welcome")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
    	
		String login = request.getParameter("login");
    	String password = request.getParameter("password");
	    
    	// База Данных
    	User user = new User();
    	try {
			user.connectToSQL();
		} catch (NamingException e) {
			e.printStackTrace();
		}
    	user.createStatement();
    	//Проверка
    	if(user.userIsExist(login, password)) {
    		user.setRoleFromID(user.getID(login)); 		
    		request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("login", login);            
    	}else {
			PrintWriter printWriter = response.getWriter();
			printWriter.print("Sorry UserName or Password Error!");
		} 
    	request.getSession().setAttribute("role", user.getRole());
    	redirect(request, response);
    	
	}
	public void redirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("role") == User.ROLE.USER) {
			response.sendRedirect("user_menu.jsp");
			//request.getRequestDispatcher("/user_menu.jsp").forward(request, response);
		}else if(request.getSession().getAttribute("role") == User.ROLE.ADMIN) {
			response.sendRedirect("admin_menu.jsp");
			//request.getRequestDispatcher("/admin_menu.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	 }
	 

}