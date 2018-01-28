package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enrollments")
public class Enrollment implements Serializable{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="Subjects_code")
	private int subject_code;
	
	@Column(name="Subjects_Carrers_idCarrer")
	private int idCarrer;
	
	@Column(name="Students_username")
	private String student_username;
	
	@Column(name="status")
	private String status;
	
	@Column(name="markOne")
	private float markOne;
	
	@Column(name="markTwo")
	private float markTwo;
	
	@Column(name="average")
	private float average;

	public Enrollment(){
	}

	public Enrollment(int id, int subject_code, int idCarrer, String username, String status, float markOne, float markTwo, float avg) {
		this.id = id;
		this.subject_code = subject_code;
		this.idCarrer = idCarrer;
		this.student_username = username;
		this.status = status;
		this.markOne = markOne;
		this.markTwo = markTwo;
		this.average = avg;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSubject_code(int subject_code){
		this.subject_code = subject_code;
	}
	
	public int getSubject_code() {
		return subject_code;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public float getMarkOne() {
		return markOne;
	}

	public void setMarkOne(float markOne) {
		this.markOne = markOne;
	}

	public float getMarkTwo() {
		return markTwo;
	}

	public void setMarkTwo(float markTwo) {
		this.markTwo = markTwo;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}
	
}
