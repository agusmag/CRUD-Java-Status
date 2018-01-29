package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="carrers")
public class Carrer implements Serializable{
	
	@Id
	@Column(name="idCarrer")
	private int idCarrer;
	
	@Column(name="name")
	private String name;

	@OneToMany(mappedBy = "carrer", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();
	
	@OneToMany(mappedBy = "carrer", cascade = CascadeType.ALL)
	private List<Subject> subjects = new ArrayList<>();
	
	public Carrer() {
	}
	
	public Carrer(int idCarrer, String name) {
		super();
		this.idCarrer = idCarrer;
		this.name = name;
	}

	public int getIdCarrer() {
		return idCarrer;
	}

	public void setIdCarrer(int idCarrer) {
		this.idCarrer = idCarrer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Carrer [idCarrer=" + idCarrer + ", name=" + name + "]";
	}
	
}
