import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfFileParser {
 
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
    	PDDocument document = PDDocument.load(new File("C:\\Users\\Hee\\Desktop\\Hees\\test.pdf"));
    	if (!document.isEncrypted()) {
    	    PDFTextStripper stripper = new PDFTextStripper();
    	    String text = stripper.getText(document);
    	    System.out.println("Text:" + text);
    	}
    	document.close();
    }
}
