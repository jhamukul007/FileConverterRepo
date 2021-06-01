package com.annotation.process;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.nio.charset.Charset;
import java.util.Base64;

import com.annotation.demo.MaskField;

public class PeocessorConstants {
	
	/*
	 * private boolean isExistingAnnotation(Annotation[] annotations, Annotation
	 * matcher) {
	 * 
	 * }
	 */
	
	public static String maskEntity(int[] indexes, String value) {
		if(value==null ) 
			return value;
		int len=value.length();
		if(indexes[0] >=len || indexes[1]>=len)
			return value;
		if(indexes[0]>=indexes[1]) 
			return value;
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<value.length();i++) {
			if(i>= indexes[0] && i<=indexes[1]) {
				sb.append("*");
			}
			else
				sb.append(value.charAt(i));
		}
		return sb.toString();
	}
	
	public static class HashUtil{
		
		public static String encode(String toEncode) throws UnsupportedEncodingException {
			return new String(Base64.getEncoder().encode(toEncode.getBytes()));
		}
		
		public static String decode(String toDecode) {
			return new String(Base64.getDecoder().decode(toDecode.getBytes()));
		}
	}
	
	public static void main(String[] args) {
		String name="mukul123";
		try {
			System.out.println("Original : "+name);
			String encoded=PeocessorConstants.HashUtil.encode(name);
			System.out.println("encoded: "+encoded);
			System.out.println("Decoded : "+PeocessorConstants.HashUtil.decode(encoded));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
