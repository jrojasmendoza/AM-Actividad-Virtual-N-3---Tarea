package pe.edu.cibertec.proyemp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_DEPARTAMENTO")
public class Departamento {

	@Id
	@GeneratedValue
	@Column(name="DEP_ID")
	private Long id;
	
	@Column(name="DEP_NOMBRE")
	private String nombre;

	public Departamento(){}
	
	public Departamento(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
