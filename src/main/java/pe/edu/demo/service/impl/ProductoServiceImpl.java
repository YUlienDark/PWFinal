package pe.edu.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.demo.model.entity.Producto;
import pe.edu.demo.model.repository.ProductoRepository;
import pe.edu.demo.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository produrepo;
	@Transactional(readOnly = true)
	@Override
	public List<Producto> findAll() throws Exception {
		
		return produrepo.findAll();
	}
	@Transactional
	@Override
	public Producto save(Producto t) throws Exception {
		return produrepo.save(t);
	}
	@Transactional
	@Override
	public Producto update(Producto t) throws Exception {
		return produrepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
	    return produrepo.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		produrepo.deleteById(id);
		
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception {
	produrepo.deleteAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Producto> findModelo(String modelo) {
		
		return produrepo.findModelo(modelo);
	}

}
