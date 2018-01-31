package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student implements Serializable{
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Carrers_idCarrer")
	private Carrer carrer;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Enrollment> enrollments = new ArrayList<>();

	public Student(String username, String password, String name, String lastName, Carrer carrer,
			List<Enrollment> enrollments) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.carrer = carrer;
		this.enrollments = enrollments;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Carrer getCarrer() {
		return carrer;
	}

	public void setCarrer(Carrer carrer) {
		this.carrer = carrer;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public boolean containSubject(String subjectName) {
		for (Enrollment enrollment : this.getEnrollments()) {
			if (enrollment.getSubject().getName().equals(subjectName))
				return true;
		}
		return false;
	}
	
	public Enrollment getEnrollment(String subjectName){
		for (Enrollment enrollment : enrollments) {
			if (enrollment.getSubject().getName().equals(subjectName))
				return enrollment;
		}
		return null;
	}
	
	public void setEnrollment(Enrollment enrollmentLocal) {
		for (Enrollment enrollment : enrollments) {
			if (enrollment.getSubject().getName().equals(enrollmentLocal.getSubject().getName()))
				enrollment = enrollmentLocal;
		}
	}

	@Override
	public String toString() {
		return "Student [username=" + username + ", name=" + name + ", lastName=" + lastName + ", carrer=" + carrer
				+ "]";
	}
	
}