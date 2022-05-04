package servlet;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.File;
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
@WebServlet("/CreatePDF")
public class CreatePDF extends HttpServlet {
private String filePath;
private String absPath;
private String imagePath;
private String fontPath;
private BaseFont times = null;
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
request.getRequestDispatcher("/FirstPdf.pdf").forward(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");

String nameOrg = request.getParameter("nameOrg");
String date = request.getParameter("date");
String fio = request.getParameter("FIO");
String podrazdelenie = request.getParameter("podrazdelenie");
String doljnost = request.getParameter("doljnost");
String cost = request.getParameter("cost");
String amountDetails = request.getParameter("amountDetails");
String allowance = request.getParameter("allowance");
getFilePath();
Document document = new Document();
try {
PdfWriter.getInstance(document, new FileOutputStream(filePath));
document.open();
} catch (Exception e) {
e.printStackTrace();
}
try {
times = BaseFont.createFont(fontPath, "cp1251", BaseFont.EMBEDDED);
} catch (DocumentException | IOException e) {
e.printStackTrace();
}
/* Первая строка */
Paragraph paragraph = new Paragraph();
paragraph.add(new Paragraph(nameOrg, new Font(times,18)));
/* Вторая строка */
String string_pdf2 = "Расчетный лист за " + date;
paragraph.add(new Paragraph(string_pdf2, new Font(times,16)));
/* Третья строка */
String string_pdf3 = "ФИО: " + fio;
paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
/* Четвертая строка */
String string_pdf4 = "Подразделение: " + podrazdelenie;
paragraph.add(new Paragraph(string_pdf4, new Font(times,14)));
/* Пятая строка */
String string_pdf5 = "Должность: " + doljnost;
paragraph.add(new Paragraph(string_pdf5, new Font(times,14)));
/* Шестая строка */
String string_pdf6 = "Ставка: " + cost;
paragraph.add(new Paragraph(string_pdf6, new Font(times,14)));
/* Седьмая строка */
String string_pdf7 = "Количество деталей: " + amountDetails;
paragraph.add(new Paragraph(string_pdf7, new Font(times,14)));
/* Пустая строка перед таблицей */
paragraph.add(" ");

try {
document.add(paragraph);
} catch (DocumentException e1) {
e1.printStackTrace();
}
paragraph.clear();
/* Картинка */
Image img = null;
try {
img = Image.getInstance(imagePath);
} catch (BadElementException e2) {
e2.printStackTrace();
} catch (MalformedURLException e2) {
e2.printStackTrace();
} catch (IOException e2) {
e2.printStackTrace();
}
img.setAbsolutePosition(500, 740);

try {
document.add(img);
} catch (DocumentException e) {
e.printStackTrace();
}
paragraph.clear();

try {
document.add(paragraph);
} catch (DocumentException e1) {
e1.printStackTrace();
}

PdfPTable table = new PdfPTable(4);
addHeader(table);
addRows(table, "Надбавка ", date, allowance, "-");
try {
document.add(table);
} catch (DocumentException e) {
e.printStackTrace();
}
document.close();
doGet(request,response);
}
private void addRows(PdfPTable table, String cell1, String cell2, String cell3, String cell4) {

table.addCell((new Phrase(cell1, new Font(times,14))));
table.addCell((new Phrase(cell2, new Font(times,14))));
table.addCell((new Phrase(cell3, new Font(times,14))));
table.addCell((new Phrase(cell4, new Font(times,14))));


}
private void addHeader(PdfPTable table) {
Stream.of("Начислено / Удержано", "За период", "Начислено", "Удержано")
.forEach(columnTitle -> {
PdfPCell header = new

    PdfPCell();
    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
    header.setBorderWidth(2);
    header.setPhrase(new Phrase(columnTitle, new Font(times,14)));
    table.addCell(header);
    });
    }
    public void getFilePath() throws IOException{
    ServletContext context = getServletContext();
    absPath = context.getRealPath("/");
    String separator = File.separator;

    filePath = absPath +"FirstPdf.pdf";
    imagePath = absPath +"images"+separator+"ugatu.png";
    fontPath = absPath +"fonts"+separator+"times.ttf";

    }
    }

