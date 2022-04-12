package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import calculator.*;

@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
    	
    	request.getRequestDispatcher("/admin_menu.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
		int amountDetails = Integer.parseInt(request.getParameter("amountDetails"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		int allowance = Integer.parseInt(request.getParameter("allowance"));
		Salary salaryOb = new Salary(amountDetails,cost,allowance);
		long salary = salaryOb.calc();
		Tax ndfl = new Tax(13);
		Deducation PF = new Deducation(22);
		Deducation FOMS = new Deducation(51); 
		Deducation FSS = new Deducation(29);  
		Deducation FSSNS = new Deducation(2); 
		request.setAttribute("salary", salary);
		request.setAttribute("NDFL", ndfl.calc());
		request.setAttribute("PF", PF.calc());
		request.setAttribute("FOMS", FOMS.calc());
		request.setAttribute("FSS", FSS.calc());
		request.setAttribute("FSSNS", FSSNS.calc());
		
		doGet(request, response);
	}

}
