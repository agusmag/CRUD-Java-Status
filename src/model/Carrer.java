package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carrers")
public class Carrer implements Serializable{
	
	@Id
	@Column(name="idCarrer")
	private int id;
	
	@Column(name="name")
	private String name;
	
	public Carrer() {
	}
	
	public Carrer(int index){
		this.id = index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
