package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="enrollment")
public class Enrollment implements Serializable{
	
	@Column(name="Subjects_code")
	private int subject_code;
	
	@Column(name="Subjects_Carrers_idCarrer")
	private int idCarrer;
	
	@Column(name="Students_username")
	private String student_username;

	public int getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(int subject_code) {
		this.subject_code = subject_code;
	}

	public int getIdCarrer() {
		return idCarrer;
	}

	public void setIdCarrer(int idCarrer) {
		this.idCarrer = idCarrer;
	}

	public String getStudent_username() {
		return student_username;
	}

	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}
}
