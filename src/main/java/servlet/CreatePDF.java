package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("serial")
public class CreatePDF extends HttpServlet {
	
	public static String NumberGet;
	public static String GroupGet;
	public static String FIOGet;
	public static String PointsGet;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/admin_menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributes(request);
		
		request.getRequestDispatcher("/admin_menu.jsp").forward(request, response);
				 
		CreatePDF PDF = new CreatePDF();
		PDF.Create();
		//doGet(request, response);
	}
	///////////
	private static class RequestCalc {
		private final String TextNumber;
		private final String TextGroup;
		private final String TextFIO;
		private final String TextPoints;

						
		private RequestCalc (String Number, String Group, String FIO, String Points) {
			this.TextNumber = Number;
			this.TextGroup = Group;
			this.TextFIO = FIO;
			this.TextPoints = Points;
			
			NumberGet=TextNumber;
			GroupGet=TextGroup;
			FIOGet=TextFIO;
			PointsGet=TextPoints;
			
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("Number"),
			request.getParameter("Group"),
			request.getParameter("FIO"),
			request.getParameter("Points"));
			}
			
		public void setAsRequestAttributes(HttpServletRequest request) {
			
			request.setAttribute("Number", TextNumber);
			request.setAttribute("Group", TextGroup);
			request.setAttribute("FIO", TextFIO);
			request.setAttribute("Points", TextPoints);

		}
		
	}
////////////////////////////////////////////////////	
		BaseFont times = null;
	    public void Create() throws IOException {
	      	
	    	Document document = new Document();
	    	
	    	String filepath = new File("").getCanonicalPath();
			String[] parsfilepath = filepath.split("/");
			
			int lengthpath = parsfilepath.length;
			String abspath=""; 
			for(int i=0;i<(lengthpath-1);i++) {
				abspath=abspath+parsfilepath[i]+"/";
			}
			filepath=abspath+"webapps/CreatePDF/Check.pdf";
			String imagepath=abspath+"webapps/images/ugatu_logo.png";
			String fontpath =abspath+"webapps/fonts/times.ttf";
	    	
			try {	
				PdfWriter.getInstance(document, new FileOutputStream(filepath));
			} catch (FileNotFoundException | DocumentException e) {
				e.printStackTrace();
			}
						
			document.open(); 
			
			//BaseFont times = null;
			try {
				times = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
			} catch (DocumentException | IOException e) {
				e.printStackTrace();
			}
			
			String string_pdf = "Информация по генерации PDF документа.";
			Paragraph paragraph = new Paragraph();
		    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
		    
		    String string_pdf2 = "Все работает как надо! Используйте в своих курсовых работах!";
		    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
		
		    try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
		    
			 paragraph.clear();
			 String string_pdf3 = " ";
			 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
			 
			 try {
					document.add(paragraph);
				} catch (DocumentException e1) {
					e1.printStackTrace();
				}
	    	
		    
		    Image img = null;
			try {
				img = Image.getInstance(imagepath);
				img.setAbsolutePosition(90, 500); 	
				
			} catch (BadElementException e2) {
				
				e2.printStackTrace();
			} catch (MalformedURLException e2) {
				
				e2.printStackTrace();
			} catch (IOException e2) {
				
				e2.printStackTrace();
			}
			
		//	img.setAbsolutePosition(90, 500); 
			
			try {
					document.add(img);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
		    

			 paragraph.clear();
			 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
			 
			 try {
					document.add(paragraph);
				} catch (DocumentException e1) {
					e1.printStackTrace();
				}
		    

			 PdfPTable table = new PdfPTable(4); 
			 addHeader(table);
			 addRows(table);
			 
			 try {
				document.add(table);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		    
		    document.close(); 
	    }
	    
	private void addRows(PdfPTable table) {
			
			String cell1 = "ghbff";
			String cell2 = "sdlfdsl";
			String cell3 = "dfsfdsfds";
			String cell4 = "123456789----";
					
			table.addCell((new Phrase(cell1, new Font(times,14))));
		    table.addCell((new Phrase(cell2, new Font(times,14))));
		    table.addCell((new Phrase(cell3, new Font(times,14))));
		    table.addCell((new Phrase(cell4, new Font(times,14))));
			
		}
	private void addHeader(PdfPTable table) {
		Stream.of("Номер", "Группа", "ФИО", "Оценка")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle, new Font(times,14)));
	        table.addCell(header);
	    });
	}
}
