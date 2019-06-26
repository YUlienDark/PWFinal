package pe.edu.demo.service;

import java.util.List;

import pe.edu.demo.model.entity.Producto;

public interface ProductoService extends CrudService<Producto,Integer>{
	List<Producto> findModelo(String modelo);
}
