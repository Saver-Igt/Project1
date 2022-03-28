package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = "/name")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");
    	
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	
    	PrintWriter out = response.getWriter(); 
    	out.println("Hello!");
    	out.println("Вы вошли под логином: " + login);
    	
    	out.print("<br>");
    	out.print("<a href ='http://localhost:8080/TEst/jsp/start.jsp'>Назад</a>");
    	out.close();
    	//request.getRequestDispatcher("Calc.java").forward(request,response);
	}
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	response.setContentType("text/html;charset=utf-8");	
	 }

}
