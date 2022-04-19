package servlet;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Coefficients;

@SuppressWarnings("serial")
@WebServlet("/settings")
public class Settings extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin_menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Coefficients BD = new Coefficients();
		try {
			BD.connectToSQL();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		BD.createStatement();
		
		float ndfl = Float.parseFloat(request.getParameter("NDFL"));
		float pf = Float.parseFloat(request.getParameter("PF"));
		float foms = Float.parseFloat(request.getParameter("FOMS"));
		float fss = Float.parseFloat(request.getParameter("FSS"));
		float fssns = Float.parseFloat(request.getParameter("FSSNS"));
		
		BD.setPercentFromID(ndfl, 1);
		BD.setPercentFromID(pf, 2);
		BD.setPercentFromID(foms, 3);
		BD.setPercentFromID(fss, 4);
		BD.setPercentFromID(fssns, 5);
		
		doGet(request, response);
	}

}
