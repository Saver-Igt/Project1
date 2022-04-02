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

import database.UsersDB;
@WebServlet("/registretion")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
    	
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	
    	// База Данных
    	UsersDB db = new UsersDB();
    	try {
			db.connectToSQL();
		} catch (NamingException e) {
			e.printStackTrace();
		}
    	db.createStatement();
    	PrintWriter printWriter = response.getWriter();
    	
    	if(!db.checkForUniqueLogin(db.getStatement(), login)) {
    		db.insertInBase(db.getStatement(), login, password);
			printWriter.print("Registration success!");
	        RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");  
	        rd.include(request, response); 
    	}else{
    		printWriter.print("<div class = \"registrationTest\" Login is already taken. Try another login </div>");
	        RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");  
	        rd.include(request, response); 
    	}
    	
    //Проверка без БД	
    /*	if(login.equals("admin")) {
    		System.out.println("Login is already taken. Try another login");
	        RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");  
	        rd.include(request, response); 
    	}else {
    		
			printWriter.print("Registration success!");
	        RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");  
	        rd.include(request, response); 
    	}
    	*/
	}

}
