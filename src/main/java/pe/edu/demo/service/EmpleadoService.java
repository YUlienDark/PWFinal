package pe.edu.demo.service;

import java.util.List;

import pe.edu.demo.model.entity.Empleado;

public interface EmpleadoService extends CrudService<Empleado,Integer>{
	List<Empleado> findByNombreApellido(String nombre ,String apellido) throws Exception;
}
