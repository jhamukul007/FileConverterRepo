package com.converter.resources;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.converter.enums.FileTypeEnum.FileType;
import com.converter.utils.ConvertFilesUtil;

import lombok.Data;

@Component
@PropertySource("classpath:file-location.properties")
@Data
public class FileLocation {
	
	@Value("${file.pdf.location}")
	private String pdfFileLocation;
	
	@Value("${file.text.location}")
	private String textFileLocation;
	
	/**
	 * Get File type store location 
	 * @param file
	 * @return
	 */
	public String getStoreFileLocation(FileType fileType) {
		if(fileType==null) {
			return "";
		}
		switch (fileType) {
		case PDF:
			return getPdfFileLocation();
		case TEXT:
			return getPdfFileLocation();
		default:
			break;
		}
		return "";
	}
	
	public String getFileCompleteStoreLocation(FileType fileType) {
		String fileLocation=getStoreFileLocation(fileType);
		if(StringUtils.isEmpty(fileLocation))
			return "";
		String fileName=ConvertFilesUtil.getIns().getDefaultFileName(fileType.getType());
		return fileLocation+"/"+fileName;
	}
	
}
