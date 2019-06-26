package pe.edu.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.demo.model.entity.Cotizacion;
import pe.edu.demo.model.repository.CotizacionRepository;
import pe.edu.demo.service.CotizacionService;
@Service
public class CotizacionServiceImpl implements CotizacionService{

	@Autowired
	private CotizacionRepository cotirepo;
	@Transactional(readOnly = true)
	@Override
	public List<Cotizacion> findAll() throws Exception {
		
		return cotirepo.findAll();
	}

	@Transactional
	@Override
	public Cotizacion save(Cotizacion t) throws Exception {
		return cotirepo.save(t);
	}
	
	@Transactional
	@Override
	public Cotizacion update(Cotizacion t) throws Exception {
	return cotirepo.save(t);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Cotizacion> findById(Integer id) throws Exception {
		return cotirepo.findById(id);
	}
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		cotirepo.deleteById(id);
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		cotirepo.deleteAll();
		
	}

}
