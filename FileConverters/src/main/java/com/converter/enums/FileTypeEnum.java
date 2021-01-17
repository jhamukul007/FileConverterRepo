package com.converter.enums;

public class FileTypeEnum {
	public enum FileType {
		
		PDF("pdf"){
			@Override
			public String getExtension() {
				return ".pdf";
			}
		},
		TEXT("text"){
			@Override
			public String getExtension() {
				return ".txt";
			}
		},HTML("html"){
			@Override
			public String getExtension() {
				return ".html";
			}
		},
		IMAGE_JPG("image jpg"){
			@Override
			public String getExtension() {
				return ".jpg";
			}
		},
		IMAGE_PNG("image png"){
			@Override
			public String getExtension() {
				return ".png";
			}
		},DOC("doc"){
			@Override
			public String getExtension() {
				return ".jpg";
			}
		};
		
		private String type;
		FileType(String type) {
			this.type=type;
		}
		public String getType() {
			return type;
		}
		public String getExtension() {
			return "";
		}
	}
}
