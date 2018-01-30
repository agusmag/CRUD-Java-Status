package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="enrollments")
public class Enrollment implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="status")
	private String status;

	@Column(name="markOne")
	private float markOne;
	
	@Column(name="markTwo")
	private float markTwo;
	
	@Column(name="average")
	private float average;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Subjects_code")
	private Subject subject;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Students_username")
	private Student student;
	
	public Enrollment(){
	}

	public Enrollment(int id, String status, float markOne, float markTwo, float average, Subject subject,
			Student student) {
		this.id = id;
		this.status = status;
		this.markOne = markOne;
		this.markTwo = markTwo;
		this.average = average;
		this.subject = subject;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", status=" + status + ", markOne=" + markOne + ", markTwo=" + markTwo
				+ ", average=" + average + ", subject=" + subject.getName() + ", student=" + student.getUsername() + "]";
	}
	
}
