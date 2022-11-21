package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalles")
//@Embeddable
public class Detalle implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDetalle;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@Column(name="importe")
	private double importe;
	
	@ManyToOne
	@JoinColumn(name="factura_id")
	private Factura factura;
	
	public Detalle() {
		
	}

	public Detalle(int cantidad, Producto producto,double importe) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.importe = importe;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public double calcularImporte() {
		this.importe = (this.cantidad*(this.producto.getPrecioUnitario()));
		return (this.importe);
	}

	@Override
	public String toString() {
		return "Detalle [Descripcion= " + producto.getDescripcion()+ producto.getDescuento()+ " cantidad=" + cantidad + ", Precio Unitario=" + producto.getPrecioUnitario() + ", IMPORTE="
				+ importe + "]";
	}
}
