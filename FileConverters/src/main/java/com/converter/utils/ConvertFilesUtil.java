package com.converter.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.springframework.stereotype.Component;

import com.converter.enums.FileTypeEnum.FileType;
import com.converter.model.Files;

@Component
public class ConvertFilesUtil extends BaseUtil{

	@Override
	public void convertToFile(Files files) {
		FormDataMultiPart parts=files.getForm();
		if(parts==null) {
			LOG.warn("Incomming file parts can't be null");
			return;
		}
		List<FormDataBodyPart> bodyParts=parts.getFields("file");
		FormDataBodyPart bodyPart=null;
		if(bodyParts.isEmpty()) {
			LOG.warn("BodyPart doesn't exist in file part");
			return;
		}
		bodyPart=bodyParts.get(0);
		InputStream streams=bodyPart.getValueAs(InputStream.class);

		try {
			File file=createLocalBackup(streams, files.getConvertFrom());
			files.setAsFile(file);
		}
		catch (Exception e) {
			LOG.error("Getting error while creating backup to local ",e);
		}
	}
	/**
	 * Backup your file to local
	 * @param streams
	 * @param fileType
	 * @return
	 * @throws IOException
	 */
	private File createLocalBackup(InputStream streams,FileType fileType) throws IOException {
		if(streams==null) {
			LOG.warn("Can't converted to streams");
			return null;
		}
		File file=File.createTempFile(getDefaultFileName(fileType.getType()), fileType.getExtension());
		OutputStream outStreams=new FileOutputStream(file);
		IOUtils.copy(streams, outStreams);
		return file;
	}
	/**
	 * Default file name preix + timestamp
	 * @param prefix
	 * @return
	 */
	public String getDefaultFileName(String prefix) {
		long currentTime=new Date().getTime();
		String fileName=prefix+String.valueOf(currentTime);
		return fileName;
	}
	
	private static class ConvertFilesUtilHelper{
		private static final BaseUtil INS=new ConvertFilesUtil();
	}
	
	public static BaseUtil getIns() {
		return ConvertFilesUtilHelper.INS;
	}
}
