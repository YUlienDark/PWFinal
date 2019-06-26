package pe.edu.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER(4)",nullable=false)
	private Integer idProducto;
	@Column(length = 10,nullable = false)
	private String nombre;
	private Integer stock;
	@Column(columnDefinition= "DECIMAL(5,2)", nullable =false)
	private double costounitario;
	@Column(length = 10,nullable = false)
	private String modelo;
	@Column(length =10 , nullable = false)
	private String Estado;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_cotizacion", nullable = true)
	private Cotizacion cotizacion;
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public double getCostounitario() {
		return costounitario;
	}
	public void setCostounitario(double costounitario) {
		this.costounitario = costounitario;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Cotizacion getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}
	
	
	
	

}
