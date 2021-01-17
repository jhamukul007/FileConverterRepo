package com.converter.services.pdfconverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.converter.model.Files;
import com.converter.utils.ConvertFilesUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class TextPdfConverter extends BasePDFConverter {

	@Override
	public void convertFile(Files files) {
		if(files==null) {
			LOG.warn("files can't be null while converting");
			return;
		}
		ConvertFilesUtil.getIns().convertToFile(files);
		File file=files.getAsFile();
		if(file==null) {
			LOG.warn("Can't converted as file ");
			return;
		}
		Document doc=new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(location.getFileCompleteStoreLocation(files.getConvertTo())))
			.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			doc.open();
			doc.add(new Paragraph("\n"));
			createPdfFile(doc, files);
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Font getFont() {
		Font font=new Font();
		font.setStyle(Font.NORMAL);
		font.setSize(11);
		return font;
	}
	/**
	 * Create PDF File to Specific Location
	 * @param doc
	 * @param files
	 * @throws IOException
	 * @throws DocumentException
	 */
	private void createPdfFile(Document doc,Files files) throws IOException, DocumentException {
		BufferedReader br=new BufferedReader(new FileReader(files.getAsFile()));
		String strLine;
		while((strLine=br.readLine() )!=null) {
			Paragraph para=new Paragraph(strLine + "\n",getFont());
			para.setAlignment(Element.ALIGN_JUSTIFIED);
			doc.add(para);
		}
		br.close();
		doc.close();
	}

	@Override
	public void convertVice(Files files) {
		// TODO Auto-generated method stub
	}

}
