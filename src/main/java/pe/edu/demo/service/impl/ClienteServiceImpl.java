package pe.edu.demo.service.impl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.demo.model.entity.Cliente;
import pe.edu.demo.model.repository.ClienteRepository;
import pe.edu.demo.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienterepository;
	
	@Transactional(readOnly =true)
	@Override
	public List<Cliente> findAll() throws Exception {
		
		return clienterepository.findAll();
	}
	
	@Transactional
	@Override
	public Cliente save(Cliente t) throws Exception {
	
		return clienterepository.save(t);
	}

	@Transactional
	@Override
	public Cliente update(Cliente t) throws Exception {
		
		return clienterepository.save(t);
	}
	
	@Transactional
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		
		return clienterepository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		clienterepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		clienterepository.deleteAll();
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findRazon(String razon) throws Exception {
		
		return clienterepository.findRazon(razon);
	}

}
