package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{

}
