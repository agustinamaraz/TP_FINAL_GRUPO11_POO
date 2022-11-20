package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProducto;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="marca")
	private String marca;
	@Column(name="origen")
	private String origen;
	@Column(name="categoria")
	private String categoria;
	@Column(name="descuento")
	private int descuento;
	@Column(name="precio_unitario")
	private double precioUnitario;
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String descripcion, String marca, String origen, String categoria, int descuento, double precioUnitario) {
		super();
		this.descripcion = descripcion;
		this.marca = marca;
		this.origen = origen;
		this.categoria = categoria;
		this.descuento = descuento;
		this.precioUnitario = precioUnitario;
	}
	public Long getidProducto() {
		return idProducto;
	}
	public void setidProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", marca=" + marca + ", origen=" + origen
				+ ", categoria=" + categoria + ", descuento=" + descuento + ", precioUnitario=" + precioUnitario + "]";
	}
	
}
