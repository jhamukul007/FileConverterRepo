package com.converter.model;

import java.io.File;
import java.io.Serializable;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import com.converter.enums.FileTypeEnum.FileType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Files implements Cloneable,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4639431825683984759L;
	private FormDataMultiPart form;
	private FileType convertFrom;
	private FileType convertTo;
	private File asFile;
	private String fileName;
}
