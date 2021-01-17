package com.converter.apis.pdf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.converter.constants.pdf.PDFApiConstants;
import com.converter.model.Files;
import com.converter.services.pdfconverter.BasePDFConverter;

@RestController(value = PDFApiConstants.VERSION_1+PDFApiConstants.BASE_URL)
public class RestPdfApi extends BasePdfApi {
	
	@Autowired
	@Qualifier(value = "TextPdfConverter")
	protected BasePDFConverter pdfConverService; 
	
	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> convertTextToPdf(@RequestBody Files files){
		if(files==null)
			return new ResponseEntity<Object>("Please upload the file",HttpStatus.BAD_REQUEST);
		try {
			pdfConverService.convertFile(files);
		}
		catch (Exception e) {
			LOG.error("Getting error while converting file to pdf ",e);
			return new ResponseEntity<Object>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>("Sucessfully Converted",HttpStatus.OK);
	}
}
