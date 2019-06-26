package pe.edu.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.demo.model.entity.Empleado;
import pe.edu.demo.model.repository.EmpleadoRepository;
import pe.edu.demo.service.EmpleadoService;
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository emplerepo;
	@Transactional(readOnly = true)
	@Override
	public List<Empleado> findAll() throws Exception {
		
		return emplerepo.findAll();
	}
	
	@Transactional
	@Override
	public Empleado save(Empleado t) throws Exception {
		
		return emplerepo.save(t);
	}
	
	@Transactional
	@Override
	public Empleado update(Empleado t) throws Exception {
		
		return emplerepo.save(t);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Empleado> findById(Integer id) throws Exception {
		return emplerepo.findById(id);
	}
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		emplerepo.deleteById(id);
		
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception {
	emplerepo.deleteAll();
	}

	@Transactional
	@Override
	public List<Empleado> findByNombreApellido(String nombre, String apellido) throws Exception {
		
		return emplerepo.findByNombreApellido(nombre, apellido);
	}

}
