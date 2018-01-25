package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	private ArrayList<Integer> correlativeList;
	
	@Column(name="hoursWeek")
	private int hoursWeek;
	
	@Column(name="Carrers_idCarrer")
	private int idCarrer;
	
	public Subject() {
	}
	
	public Subject (String name, int code, String correlatives, int hoursWeek){
		this.name = name;
		this.code = code;
		this.correlatives = correlatives;
		this.hoursWeek = hoursWeek;
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

	public ArrayList<Integer> getCorrelativeList() {
		return correlativeList;
	}

	public void setCorrelativeList(ArrayList<Integer> correlativeList) {
		this.correlativeList = correlativeList;
	}

	public int getHoursWeek() {
		return hoursWeek;
	}

	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
	}

	public int getIdCarrer() {
		return idCarrer;
	}

	public void setIdCarrer(int idCarrer) {
		this.idCarrer = idCarrer;
	}
	
}