package com.converter.services.pdfconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.model.Files;
import com.converter.resources.FileLocation;
import com.converter.services.AbstractServices;

@Service
public abstract class BasePDFConverter extends AbstractServices{
	
	@Autowired
	protected FileLocation location;
	/**
	 * It ll convert vice-versa like <tt> pdf to text, then it ll convert text to pdf</tt>
	 * @param files
	 */
	public abstract void convertVice(Files files);
}
