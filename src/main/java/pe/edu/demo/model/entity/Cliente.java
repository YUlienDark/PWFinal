package pe.edu.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition ="INTEGER(4)",nullable = false)
	private Integer idCliente;
	@Column(nullable = false)
	private String Razonsocial;
	@Column(name ="tipodocumento", nullable = false)
	private String tipo_doc;
	
	@Column(name = "numerodocumento", nullable = false)
	private Integer num_doc;
	
	@Column(name = "numerotelefono", nullable = false)
	private Integer num_telf;
	@Column(length = 10,nullable = false)
	private String estado;
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getRazonsocial() {
		return Razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		Razonsocial = razonsocial;
	}
	public String getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public Integer getNum_doc() {
		return num_doc;
	}
	public void setNum_doc(Integer num_doc) {
		this.num_doc = num_doc;
	}
	public Integer getNum_telf() {
		return num_telf;
	}
	public void setNum_telf(Integer num_telf) {
		this.num_telf = num_telf;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	


}
