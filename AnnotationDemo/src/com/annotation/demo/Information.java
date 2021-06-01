package com.annotation.demo;

@SecuredBean @MaskData
public class Information {
	
	String id;
	
	@MaskField(index = {2,5})
	String userName;
	
	@EncryptionRequired @DecryptionRequired
	String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
