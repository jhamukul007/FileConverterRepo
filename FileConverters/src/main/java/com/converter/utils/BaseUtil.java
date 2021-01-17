package com.converter.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.converter.model.Files;

public abstract class BaseUtil {
	public final Logger LOG=LogManager.getLogger(this.getClass().getName());
	public abstract void convertToFile(Files files);
	public abstract String getDefaultFileName(String prefix);
}
