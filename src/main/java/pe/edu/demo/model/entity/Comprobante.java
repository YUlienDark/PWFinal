package pe.edu.demo.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "comprobantes")
public class Comprobante {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(columnDefinition ="INTEGER(4)",nullable = false )
    private Integer idComprobante;
	@Column(length = 30,nullable = false)
    private String descripcion;
	
	@Column(length=6,columnDefinition ="DECIMAL(8,2)")
    private Double totalpago;
	
	@ManyToOne( fetch=FetchType.LAZY )
	@JoinColumn(name ="id_cotizacion",nullable = false)
	private Cotizacion cotizacion;
	@ManyToOne( fetch=FetchType.LAZY )
	@JoinColumn(name = "id_empleado",nullable = false)
    private Empleado empleado;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date Fechaemision;
	
	public Integer getIdComprobante() {
		return idComprobante;
	}
	public void setIdComprobante(Integer idComprobante) {
		this.idComprobante = idComprobante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getTotalpago() {
		return totalpago;
	}
	public void setTotalpago(Double totalpago) {
		this.totalpago = totalpago;
	}
	public Cotizacion getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Date getFechaemision() {
		return Fechaemision;
	}
	public void setFechaemision(Date fechaemision) {
		Fechaemision = fechaemision;
	}
		
}
