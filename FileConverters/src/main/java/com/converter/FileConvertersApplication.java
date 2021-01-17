package com.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.converter.apis.pdf","com.converter.services.pdfconverter","com.converter.resources"})
public class FileConvertersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileConvertersApplication.class, args);
	}

}
