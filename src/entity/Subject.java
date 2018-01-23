package entity;

import java.util.ArrayList;

public class Subject {
	private String name;
	private int code;
	private ArrayList<Integer> correlatives;
	private int hoursWeek;
	
	public Subject (String name, int code, ArrayList<Integer> correlatives, int hoursWeek){
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

	public ArrayList<Integer> getCorrelatives() {
		return correlatives;
	}

	public void setCorrelatives(ArrayList<Integer> correlatives) {
		this.correlatives = correlatives;
	}

	public int getHoursWeek() {
		return hoursWeek;
	}

	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
	}
	
}
