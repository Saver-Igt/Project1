package servlet;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import calculator.*;
import database.Coefficients;
import database.User;

@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
    	Object role = request.getSession().getAttribute("role");
    	if(role == User.ROLE.USER){
    		request.getRequestDispatcher("/user_menu.jsp").forward(request, response);
    	} else if(role == User.ROLE.ADMIN)
    	request.getRequestDispatcher("/admin_menu.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");	
    	
		int amountDetails = Integer.parseInt(request.getParameter("amountDetails"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		int allowance = Integer.parseInt(request.getParameter("allowance"));
	    String nameOrg = request.getParameter("nameOrg");
	    String date = request.getParameter("date");
	    String fio = request.getParameter("FIO");
	    String podrazdelenie = request.getParameter("podrazdelenie");
	    String doljnost = request.getParameter("doljnost");

	    request.getSession().setAttribute("nameOrg", nameOrg);
	    request.getSession().setAttribute("date", date);
	    request.getSession().setAttribute("FIO", fio);
	    request.getSession().setAttribute("podrazdelenie", podrazdelenie);
	    request.getSession().setAttribute("doljnost", doljnost);
	    request.getSession().setAttribute("amountDetails", amountDetails);
	    request.getSession().setAttribute("cost", cost);
	    request.getSession().setAttribute("allowance", allowance);


		Coefficients dataBase = new Coefficients();
		try {
			dataBase.connectToSQL();
			dataBase.createStatement();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		//Резидент или нет
		float percentNDFL;
		if(request.getParameter("dzen").equals("yes")) {
			percentNDFL = dataBase.getPercentFromName("NDFL");
		}else {
			percentNDFL = dataBase.getPercentFromName("NoNDFL");
		}
		System.out.println("Ndfl - " + percentNDFL);
		float percentPF = dataBase.getPercentFromName("PF");
		float percentFOMS = dataBase.getPercentFromName("FOMS");
		float percentFSS = dataBase.getPercentFromName("FSS");
		float percentFSSNS = dataBase.getPercentFromName("FSSNS");
		
		Calculation.calcNetSalary(amountDetails, cost, allowance);
		Tax tax = new Tax(percentNDFL);
		float ndfl = tax.calc();
		Salary salary = new Salary(ndfl);
		Deducation PF = new Deducation(percentPF);
		Deducation FOMS = new Deducation(percentFOMS); 
		Deducation FSS = new Deducation(percentFSS);  
		Deducation FSSNS = new Deducation(percentFSSNS); 
		
		request.getSession().setAttribute("salary", getString(salary.calc()));
		request.getSession().setAttribute("NDFl", getString(ndfl));
		request.getSession().setAttribute("PF", getString(PF.calc()));
		request.getSession().setAttribute("FOMS", getString(FOMS.calc()));
		request.getSession().setAttribute("FSS", getString(FSS.calc()));
		request.getSession().setAttribute("FSSNS", getString(FSSNS.calc()));
		
		doGet(request, response);
	}
	public final String getString(float value) {
		String result = String.format("%.2f",value);
		return result + " руб.";
	}

}
