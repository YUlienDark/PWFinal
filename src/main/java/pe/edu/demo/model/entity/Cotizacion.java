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
@Table(name ="cotizaciones")
public class Cotizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER(5)",nullable= false)
	private Integer idCotizacion;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_cliente",nullable = false)
	private Cliente cliente;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = " id_producto",nullable = false)
	private Producto producto;
    @Column(length = 20, nullable = false)
	private String cantidad;
    @Column(length = 20 , nullable = false)
	private Double costoxcantidad;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Fechaentrega;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date FechaRecojo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Fechacotizacion;
	
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public Double getCostoxcantidad() {
		return costoxcantidad;
	}
	public void setCostoxcantidad(Double costoxcantidad) {
		this.costoxcantidad = costoxcantidad;
	}
	public Date getFechaentrega() {
		return Fechaentrega;
	}
	public void setFechaentrega(Date fechaentrega) {
		Fechaentrega = fechaentrega;
	}
	public Date getFechaRecojo() {
		return FechaRecojo;
	}
	public void setFechaRecojo(Date fechaRecojo) {
		FechaRecojo = fechaRecojo;
	}
	public Date getFechacotizacion() {
		return Fechacotizacion;
	}
	public void setFechacotizacion(Date fechacotizacion) {
		Fechacotizacion = fechacotizacion;
	}
	
}
