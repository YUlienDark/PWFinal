package pe.edu.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(columnDefinition = "INTEGER(5)" , nullable=false)
	private  Integer idEmpleado;
	@Column( nullable=false)
	private String Nombreempleado;
	@Column( nullable=false)
	private String Apellidoempleado;
	@Column( nullable=false)
	private String Genero;
	@Column( nullable=false)
	private String tipo_documento;
	@Column( nullable=false)
	private Integer num_documento;
	@Column( nullable=false)
	private String Estado;
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombreempleado() {
		return Nombreempleado;
	}
	public void setNombreempleado(String nombreempleado) {
		Nombreempleado = nombreempleado;
	}
	public String getApellidoempleado() {
		return Apellidoempleado;
	}
	public void setApellidoempleado(String apellidoempleado) {
		Apellidoempleado = apellidoempleado;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public Integer getNum_documento() {
		return num_documento;
	}
	public void setNum_documento(Integer num_documento) {
		this.num_documento = num_documento;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
}
