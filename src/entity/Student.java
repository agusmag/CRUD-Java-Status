package entity;

public class Student {
	private String username;
	private String password;
	private int idCarrer;
	
	public Student (String user, String pass, int id){
		this.username = user;
		this.password = pass;
		this.idCarrer = id;
	}

	public Student() {
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

	public int getIdCarrer() {
		return idCarrer;
	}

	public void setIdCarrer(int idCarrer) {
		this.idCarrer = idCarrer;
	}
	
}