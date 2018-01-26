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
	
	@Column(name="status")
	private char status;
	
	@Column(name="markOne")
	private float markOne;
	
	@Column(name="markTwo")
	private float markTwo;
	
	@Column(name="average")
	private float average;

	public Enrollment(){
	}

	public Enrollment(int subject_code, int idCarrer, String username, char status, float markOne, float markTwo, float avg) {
		this.subject_code = subject_code;
		this.idCarrer = idCarrer;
		this.student_username = username;
		this.status = status;
		this.markOne = markOne;
		this.markTwo = markTwo;
		this.average = avg;
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
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
