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
		float salary = salaryOb.calc();
		Tax ndfl = new Tax(13);
		Deducation PF = new Deducation(22);
		Deducation FOMS = new Deducation(5.1f); 
		Deducation FSS = new Deducation(2.9f);  
		Deducation FSSNS = new Deducation(0.2f); 
		
		request.setAttribute("salary", salary);
		request.setAttribute("NDFL", ndfl.calc());
		request.setAttribute("PF", PF.calc());
		request.setAttribute("FOMS", FOMS.calc());
		request.setAttribute("FSS", FSS.calc());
		request.setAttribute("FSSNS", FSSNS.calc());
		
		doGet(request, response);
	}
	/**
	 * Метод приводит результат к нужному формату (две цифры после запятой).
	 *
	 * @param value значение, полученное в ходе вычислений
	 * @param div делитель
	 * @return Строка с результатом
	 */
	public final String getString(long value, int div) {
		float res;
		res = (float) value / div;
		String result = String.format("%.2f",res);
		return result + " руб.";
	}

}
