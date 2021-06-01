package com.annotation.process;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import com.annotation.demo.Information;
import com.annotation.demo.MaskData;
import com.annotation.demo.MaskField;

public class AnnotationProcessor<T> {
	
	public void process(List<T> entries) {

		if(entries==null || entries.isEmpty())
			return ;
		for(int i=0;i<entries.size();i++) {
			T t=entries.get(i);
			if(t.getClass().isAnnotationPresent(MaskData.class)) {
				maskedField(t);
			}
		}
	}
	
	private void maskedField(T entry) {
		Field[] fields=entry.getClass().getDeclaredFields();
		for(Field field:fields) {
			if(field.isAnnotationPresent(MaskField.class)) {
				MaskField annotation=field.getAnnotation(MaskField.class);
				int[] index=annotation.index();
				try {
					maskField(index, field,entry);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void maskField(int[] index, Field field, T entity) throws IllegalArgumentException, IllegalAccessException {
		if(field==null)
			return;
		field.setAccessible(true);
		Object fieldValue=field.get(entity);
		if(fieldValue instanceof String) {
			String value=(String)fieldValue;
			field.set(entity, PeocessorConstants.maskEntity(index, value));
		}
	}
	
	public static void main(String[] args) {
		Information info=new Information();
		info.setId("123");
		info.setUserName("whomukul007");
		info.setPassword("123456789");
		AnnotationProcessor<Information> obj=new AnnotationProcessor<Information>();
		obj.process(Arrays.asList(info));
	}
}
