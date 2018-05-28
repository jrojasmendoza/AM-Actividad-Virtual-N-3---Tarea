package pe.edu.cibertec.proyemp.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.common.collect.Lists;

import pe.edu.cibertec.proyemp.model.Departamento;
import pe.edu.cibertec.proyemp.model.Empleado;
import pe.edu.cibertec.proyemp.service.DepartamentoService;
import pe.edu.cibertec.proyemp.service.EmpleadoService;

@ManagedBean
@SessionScoped
public class EmpleadoManagedBean {

	private Empleado empleado = new Empleado();
	
	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	private List<Departamento> departamentos = new ArrayList<Departamento>();
	
	@ManagedProperty(value = "#{empleadoService}")
	private EmpleadoService empleadoService;
	
	@ManagedProperty(value="#{departamentoService}")
	private DepartamentoService departamentoService;

	public String guardar(){
		empleadoService.getEmpleadoRepository().save(empleado);	
		empleado = new Empleado();
		return "registro_empleado";
	}
	
	public String editar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		Map parans = context.getExternalContext().getRequestParameterMap();
		String paranId = (String) parans.get("id");
		
		empleado = 
				empleadoService.getEmpleadoRepository().findOne(new Long(paranId));
		
		 
		return "editar_empleado";
	}
	
	public String eliminar(){
		empleadoService.getEmpleadoRepository().delete(empleado);

		return "registro_empleado";
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		empleados = Lists.newArrayList(
				empleadoService.getEmpleadoRepository().findAll());
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Departamento> getDepartamentos() {
		departamentos = Lists.newArrayList(departamentoService
							.getDepartamentoRepository().findAll());
		
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	public DepartamentoService getDepartamentoService() {
		return departamentoService;
	}

	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	
	
}
