package pe.edu.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.demo.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
@Query("SELECT c from Cliente c where c.Razonsocial like %?1%")
List<Cliente> findRazon(String razon);
}
