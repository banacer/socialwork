/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Nacer Khalil
 */
public class Misc {
    
    private static Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
    private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,Font.BOLD);
    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.NORMAL);
    private static Font smallbold = new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD);
    
    
    
    public static int calculateDifference(Date a, Date b)
    {
        int tempDifference = 0;
        int difference = 0;
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        if (a.compareTo(b) < 0)
        {
            earlier.setTime(a);
            later.setTime(b);
        }
        else
        {
            earlier.setTime(b);
            later.setTime(a);
        }

        while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR))
        {
            tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR))
        {
            tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }
        return difference;
    }
    
    public static int fromFloorNametoNum(String name)
    {
        System.out.println("");
        if(name.equalsIgnoreCase("rez de chaussée"))
            return 0;
        if(name.equalsIgnoreCase("Etage 1"))
            return 1;
        if(name.equalsIgnoreCase("Etage 2"))
            return 2;
        if(name.equalsIgnoreCase("Etage 3"))
            return 3;
        
        else return -1;
    }
    
    public static void printTransaction(Transaction tr)
    {
        try 
        {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("recu n° "+tr.getSerial()+".pdf"));
            document.open();
            
            document.addTitle("Trasaction numero "+tr.getSerial());        
            addContent(document,tr);
            
            document.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    
    private static void addContent(Document document, Transaction tr) throws DocumentException
    {        
        
        document.add(new Paragraph(" "));        
        document.add(new Paragraph("Reçu", bigFont));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("N° de transaction: "+tr.getSerial(), font));
        document.add(new Paragraph("Nom du patient   : "+tr.getPatient().getFullName(), font));
        document.add(new Paragraph("CIN du patient   : "+tr.getPatient().getCIN(), font));
        document.add(new Paragraph("Numero du patient: "+tr.getPatient().getNumeroPatient(), font));
        document.add(new Paragraph("Numero de chambre: "+tr.getSejour().getBed().getRoom().getFloorName()+", Chambre "
                +tr.getSejour().getBed().getRoom().getRoomNum()+", Lit "
                +tr.getSejour().getBed().getNumber(), font));
        document.add(new Paragraph("Date d'entrée    : "+tr.getpDateDentree().toString(), font));
        document.add(new Paragraph("Date de sortie   : "+tr.getpDateSortie().toString(), font));
        if(tr.getAccompagnateur() != null)
        {
            document.add(new Paragraph("Nom du compagnon : "+tr.getAccompagnateur().getFullName(), font));
            document.add(new Paragraph("CIN du compagnon : "+tr.getAccompagnateur().getCIN(), font));        
            document.add(new Paragraph("Numero de chambre: "+tr.getSejourAccompagnateur().getBed().getRoom().getFloorName()+", Chambre "
                    +tr.getSejourAccompagnateur().getBed().getRoom().getRoomNum()+", Lit "
                    +tr.getSejourAccompagnateur().getBed().getNumber(), font));
            document.add(new Paragraph("Date d'entrée    : "+tr.getaDateDentree().toString(), font));
            document.add(new Paragraph("Date de sortie   : "+tr.getaDateSortie().toString(), font));            
            document.add(new Paragraph("Total: "+tr.getSomme()+".00 MAD",font));
        }
        else
        {
            document.add(new Paragraph("Total: "+tr.getSomme()+".00 MAD",font));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));            
        }
        
        document.add(new Paragraph(" "));     
        document.add(new Paragraph(" "));     
        document.add(new Paragraph("_______________________________________________________________________________",font));
        document.add(new Paragraph(" "));       
        document.add(new Paragraph(" "));     
        //RECU NUMERO 2
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Reçu", bigFont));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("N° de transaction: "+tr.getSerial(), font));
        document.add(new Paragraph("Nom du patient   : "+tr.getPatient().getFullName(), font));
        document.add(new Paragraph("CIN du patient   : "+tr.getPatient().getCIN(), font));
        document.add(new Paragraph("Numero du patient: "+tr.getPatient().getNumeroPatient(), font));
        document.add(new Paragraph("Numero de chambre: "+tr.getSejour().getBed().getRoom().getFloorName()+", Chambre "
                +tr.getSejour().getBed().getRoom().getRoomNum()+", Lit "
                +tr.getSejour().getBed().getNumber(), font));
        document.add(new Paragraph("Date d'entrée    : "+tr.getpDateDentree().toString(), font));
        document.add(new Paragraph("Date de sortie   : "+tr.getpDateSortie().toString(), font));
        if(tr.getAccompagnateur() != null)
        {
            document.add(new Paragraph("Nom du compagnon : "+tr.getAccompagnateur().getFullName(), font));
            document.add(new Paragraph("CIN du compagnon : "+tr.getAccompagnateur().getCIN(), font));        
            document.add(new Paragraph("Numero de chambre: "+tr.getSejourAccompagnateur().getBed().getRoom().getFloorName()+", Chambre "
                    +tr.getSejourAccompagnateur().getBed().getRoom().getRoomNum()+", Lit "
                    +tr.getSejourAccompagnateur().getBed().getNumber(), font));
            document.add(new Paragraph("Date d'entrée    : "+tr.getaDateDentree().toString(), font));
            document.add(new Paragraph("Date de sortie   : "+tr.getaDateSortie().toString(), font));  
            document.add(new Paragraph("Total: "+tr.getSomme()+".00 MAD",font));
        }
        else
        {
            document.add(new Paragraph("Total: "+tr.getSomme()+".00 MAD",font));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));            
        }
    }
    
    public static void printTransactions(List<Transaction> list)
    {
        try 
        {
            Date date = new Date(Calendar.getInstance().getTimeInMillis());
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("situation_du_"+date.toString()+".pdf"));
            document.open();
            
            document.addTitle("Situation fin de journee du "+date.toString());        
            createTable(document,list);
            
            document.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public static void createTable(Document document, List<Transaction> list) throws DocumentException
    {
        PdfPTable table = new PdfPTable(9);
        PdfPCell c1 = new PdfPCell(new Phrase("Serial",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);        
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Patient",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Date d'entrée",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Date de sortie",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Accompagnateur",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Date d'entrée",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Date de sortie",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Type",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Total",smallbold));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);
        
        for(Transaction tr: list)
        {
            table.addCell(new Phrase(String.valueOf(tr.getSerial()),smallFont));
            table.addCell(new Phrase(tr.getPatient().getFullName(),smallFont));
            table.addCell(new Phrase(tr.getpDateDentree().toString(),smallFont));
            table.addCell(new Phrase(tr.getpDateSortie().toString(),smallFont));
            if(tr.getAccompagnateur() != null)
            {
                table.addCell(new Phrase(tr.getAccompagnateur().getFullName(),smallFont));
                table.addCell(new Phrase(tr.getpDateDentree().toString(),smallFont));
                table.addCell(new Phrase(tr.getpDateSortie().toString(),smallFont));
            }
            else
            {
                table.addCell("");
                table.addCell("");
                table.addCell("");
            }
            table.addCell(new Phrase(tr.getTransactionType(),smallFont));
            table.addCell(new Phrase(String.valueOf(tr.getSomme())+".00",smallFont));
            
        }
        
        document.add(table);

    }
    
}
