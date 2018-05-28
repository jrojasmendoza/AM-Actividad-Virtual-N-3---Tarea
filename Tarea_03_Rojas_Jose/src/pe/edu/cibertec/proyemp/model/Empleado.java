package pe.edu.cibertec.proyemp.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EMPLEADO")
public class Empleado {
	
	@Id
	@GeneratedValue
	@Column(name="EMP_ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "EMP_NOMBRE", length=100)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	private Departamento departamento = new Departamento();
	
	@Column(name="EMP_SALARIO", precision=10, scale=2)
	private BigDecimal salario;

	@Column(name="EMP_FEC_ING")
	@Temporal(value = TemporalType.DATE)
	private Date fechaIngreso;


	public Empleado(){}
	
	public Empleado(String nombre, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento.getNombre() + "]";
	}

	
	
}
