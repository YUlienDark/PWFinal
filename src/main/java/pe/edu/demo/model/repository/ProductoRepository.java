package pe.edu.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.demo.model.entity.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> 
{
@Query("SELECT p from Producto p where p.modelo like %?1%")
List<Producto> findModelo(String modelo);
}
