package entity;

public class Student {
	private String username;
	private String password;
	private int value;
	
	
	public Student (String user, String pass, int index){
		this.username = user;
		this.password = pass;
		this.value = index;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	
}