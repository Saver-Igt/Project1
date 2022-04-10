package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculation")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
    	
    	request.getRequestDispatcher("/user_menu.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
		String amountDetails = request.getParameter("amountDetails");
		request.getSession().setAttribute("amountDetails", amountDetails);
		doGet(request, response);
	}

}
