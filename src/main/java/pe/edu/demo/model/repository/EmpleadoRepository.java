package pe.edu.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.demo.model.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
@Query("SELECT e from Empleado e where e.Nombreempleado like %?1% and e.Apellidoempleado like %?2%")
List<Empleado> findByNombreApellido(String nombre ,String apellido);
}
