package pe.edu.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.demo.model.entity.Comprobante;
import pe.edu.demo.model.repository.ComprobanteRepository;
import pe.edu.demo.service.ComprobanteService;
@Service
public class ComprobanteServiceImpl implements ComprobanteService{

	@Autowired
	private ComprobanteRepository comprorepo;
	@Transactional(readOnly= true)
	@Override
	public List<Comprobante> findAll() throws Exception {
		
		return comprorepo.findAll();
	}

	@Transactional
	@Override
	public Comprobante save(Comprobante t) throws Exception {
		
		return comprorepo.save(t);
	}

	@Transactional
	@Override
	public Comprobante update(Comprobante t) throws Exception {
		
		return comprorepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Comprobante> findById(Integer id) throws Exception {
		
		return comprorepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
	
	comprorepo.deleteById(id);	
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		comprorepo.deleteAll();
		
	}

}
