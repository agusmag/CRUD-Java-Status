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
@Table(name="subjects")
public class Subject implements Serializable{
	@Column(name="nameSubject")
	private String name;
	
	@Id
	@Column(name="code")
	private int code;
	
	@Column(name="correlatives")
	private String correlatives;
	
	@Column(name="hoursWeek")
	private int hoursWeek;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Carrers_idCarrer")
	private Carrer carrer;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private List<Enrollment> enrollments = new ArrayList<>();
	
	public Subject() {
	}
	
	public Subject(String name, int code, String correlatives, int hoursWeek, Carrer carrer,
			List<Enrollment> enrollments) {
		this.name = name;
		this.code = code;
		this.correlatives = correlatives;
		this.hoursWeek = hoursWeek;
		this.carrer = carrer;
		this.enrollments = enrollments;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCorrelatives() {
		return correlatives;
	}

	public void setCorrelatives(String correlatives) {
		this.correlatives = correlatives;
	}

	public int getHoursWeek() {
		return hoursWeek;
	}

	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
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

	@Override
	public String toString() {
		return "Subject [name=" + name + ", code=" + code + ", correlatives=" + correlatives + ", hoursWeek="
				+ hoursWeek + ", carrer=" + carrer + "]";
	}
	
}
