package pe.edu.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.demo.model.entity.Comprobante;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante,Integer> {

}
