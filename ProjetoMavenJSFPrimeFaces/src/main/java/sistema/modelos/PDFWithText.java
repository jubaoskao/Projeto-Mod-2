package sistema.modelos;

import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class PDFWithText {
    
    @SuppressWarnings("deprecation")
	public void createPDF(List<Pergunta> perguntas, String nome, int qtde) throws IOException
    {
    	 Document doc = null;
        OutputStream os = null;
        
        if(perguntas.isEmpty())
        	return;
        
        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            os = new FileOutputStream("C:\\Temp\\" + nome  + ".pdf");
            PdfWriter.getInstance(doc, os);
            doc.open();
            int count = 1;
            int bool = 0;
            for(Pergunta perg : perguntas)
	        {
            	if(count > qtde)
            		break;
            	if (bool == 0)
            	{
            		String a = "FACENS";
            		Paragraph p0 = new Paragraph(a);
            		bool = 1;
            		 doc.add(p0);
            	}
            	String text = Integer.toString(count) + " - ";
            	count++;
	        	text += perg.getTitulo();
            	Paragraph p = new Paragraph(text);
                doc.add(p);
                Paragraph p2 = new Paragraph("Resposta: ");
                doc.add(p2);
	        }
        } 
        catch(Exception e)
        {
        	
        }
        finally {
            if (doc != null) {
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }

    }
}
