package pe.edu.demo.service;

import java.util.List;

import pe.edu.demo.model.entity.Cliente;

public interface ClienteService extends CrudService<Cliente,Integer>{
List<Cliente> findRazon(String razon) throws Exception;
}
