package com.converter.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.converter.model.Files;

@Service
public abstract class AbstractServices {
	public final Logger LOG=LogManager.getLogger(this.getClass().getName());
	abstract public void convertFile(Files files);
}
