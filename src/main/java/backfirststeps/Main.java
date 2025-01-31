package backfirststeps;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        
        String cpf = "123.456.789-10";
        String password = cpf.substring(0,5);

        String src ="C:\\Users\\ronal\\OneDrive\\Documentos\\ADS CONTENT\\POO\\Mastering_C23 (1).pdf";

        String dest = "C:\\Users\\ronal\\OneDrive\\Documentos\\ADS CONTENT\\POO\\Mastering_C23_protected.pdf";

        File srcFile = new File(src);
        if(!srcFile.exists()){
            System.out.println("Arquivo não encontrado!");
            return;
        }

        try{
            protectPdf(src, dest, password);
            System.out.println("PDF protegido com sucesso!");
        } catch (IOException | DocumentException e){
            e.printStackTrace();
        }
    }
    public static void protectPdf(String src, String dest, String password) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));

        stamper.setEncryption(password.getBytes(), password.getBytes(),
                PdfWriter.ALLOW_PRINTING,
                PdfWriter.ENCRYPTION_AES_128);

        stamper.close();
        reader.close();
        }
    }
