package PDF;

import java.io.FileOutputStream;
import java.io.IOException;
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

public class PDF {
	private BaseFont times = null;
	private Document document;
	private Paragraph paragraph;
	private PdfPTable table;
	public void create(String filePath, String fontPath) {
		document = new Document();
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
	}
	public void createTable(int columns) {
		table = new PdfPTable(columns);
	}
	public void addTableToDoc() {
		try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	public void addRows(String cell1, String cell2, String cell3, String cell4) {
		table.addCell((new Phrase(cell1, new Font(times,14))));
		table.addCell((new Phrase(cell2, new Font(times,14))));
		table.addCell((new Phrase(cell3, new Font(times,14))));
		table.addCell((new Phrase(cell4, new Font(times,14))));
	}
	public void addHeader() {
		Stream.of("Начислено / Удержано", "За период", "Начислено", "Удержано")
			.forEach(columnTitle -> {
		PdfPCell header = new PdfPCell();
	    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    header.setBorderWidth(2);
	    header.setPhrase(new Phrase(columnTitle, new Font(times,14)));
	    table.addCell(header);
	    });
	}
	public void createParagraph() {
		paragraph = new Paragraph();
	}
	public void createString(String str, int size) {
		paragraph.add(new Paragraph(str, new Font(times,size)));
		try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		paragraph.clear();
	}
	public void addImage(String imagePath) {
		Image img = null;
		try {
			img = Image.getInstance(imagePath);
			img.setAbsolutePosition(500, 740);
		} catch (BadElementException e2) {
			e2.printStackTrace();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		try {
			document.add(img);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		paragraph.clear();
	}
	public Paragraph getParagraph() {
		return paragraph;
	}
	public Document getPDoc() {
		return document;
	}
}