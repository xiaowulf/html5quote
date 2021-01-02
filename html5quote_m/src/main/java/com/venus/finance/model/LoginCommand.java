package com.venus.finance.model;

public class LoginCommand {
	private String userName;

	private String password;
	
	private String verycode;
	
	private String newpassword;
	
	private String rnewpassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVerycode() {
		return verycode;
	}

	public void setVerycode(String verycode) {
		this.verycode = verycode;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRnewpassword() {
		return rnewpassword;
	}

	public void setRnewpassword(String rnewpassword) {
		this.rnewpassword = rnewpassword;
	}
	
	
}
