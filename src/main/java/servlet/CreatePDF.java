package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import PDF.*;

@SuppressWarnings("serial")
@WebServlet("/CreatePDF")
public class CreatePDF extends HttpServlet {
	private String absPath;
	private String filePath;
	private String imagePath;
	private String fontPath;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/Расчетный_лист.pdf").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nameOrg = request.getParameter("nameOrg");
		String fio = "ФИО: "+request.getParameter("FIO");
		String podrazdelenie = "Подразделение: "+request.getParameter("podrazdelenie");
		String doljnost = "Должность: "+request.getParameter("doljnost");
		String cost = "Ставка: "+request.getParameter("cost") + " рублей за деталь";
		String amountDetails = "Количество деталей: " +request.getParameter("amountDetails") + " шт.";
		String allowance = request.getParameter("allowance") + " руб.";
		String date = "Расчетный лист за " + request.getParameter("date");
		
		String sumSotr = (String) request.getSession().getAttribute("salary");
		String NDFl = (String) request.getSession().getAttribute("NDFl") ;
		String PF = (String) request.getSession().getAttribute("PF");
		String FOMS = (String) request.getSession().getAttribute("FOMS");
		String FSS = (String) request.getSession().getAttribute("FSS");
		String FSSNS = (String) request.getSession().getAttribute("FSSNS");
		
		setPaths();
		PDF pdf = new PDF();
		pdf.create(filePath, fontPath);
		pdf.createParagraph();
		
		pdf.createString(" ", 14);
		pdf.createString(nameOrg, 18);
		pdf.createString(date, 16);
		pdf.createString(fio, 14);
		pdf.createString(podrazdelenie, 14);
		pdf.createString(doljnost, 14);
		pdf.createString(cost, 14);
		pdf.createString(amountDetails, 14);
		pdf.createString(" ", 14);
		
		pdf.addImage(imagePath);
		
		pdf.createTable(4);
		pdf.addHeader();
		pdf.addRows("Надбавка", getDate(request.getParameter("date")), allowance, "-");
		pdf.addRows("НДФЛ", getDate(request.getParameter("date")), "-", NDFl);
		pdf.addRows("ПФ", getDate(request.getParameter("date")), "-", PF);
		pdf.addRows("ФОМС", getDate(request.getParameter("date")), "-", FOMS);
		pdf.addRows("ФСС", getDate(request.getParameter("date")), "-", FSS);
		pdf.addRows("ФСС НС", getDate(request.getParameter("date")), "-", FSSNS);
		pdf.addRows("Сумма сотруднику", getDate(request.getParameter("date")), sumSotr, "-");
		pdf.addTableToDoc();
		
		pdf.getPDoc().close();
		doGet(request, response);
	}
	public String getDate(String date) {
        String[] words = date.split("-");
        return words[1] +"."+ words[2];
	}
    public void setPaths() {
    	ServletContext context = getServletContext();
 	    absPath = context.getRealPath("/");
 	    String separator = File.separator;
	    filePath = absPath +"Расчетный_лист.pdf";
	    imagePath = absPath +"images"+separator+"ugatu.png";
	    fontPath = absPath +"fonts"+separator+"times.ttf";
    }
}


