package pe.edu.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.demo.model.entity.Cotizacion;
@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion,Integer> {

}
