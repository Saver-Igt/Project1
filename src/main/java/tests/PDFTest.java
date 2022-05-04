package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Before;
import org.junit.Test;

import PDF.PDF;

public class PDFTest {

	private PDF doc;
    private String location;

    @Before
    public void setUp() {
    	location = "/test.pdf";
        doc = new PDF();
        doc.create(location);
    }

    @Test
    public void test() {
    	File pdf = new File(location);
		Path path = pdf.toPath();
		assertTrue(Files.exists(path));
    }

}
