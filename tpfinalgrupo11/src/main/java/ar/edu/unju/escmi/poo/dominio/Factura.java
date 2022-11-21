package ar.edu.unju.escmi.poo.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="facturas")
public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idFactura;
	
	@Column(name = "numero_factura",unique=true)
	private int numeroFactura;
	@Column(name="fecha_generacion")
	private LocalDate fecha;
	@Column(name="total")
	private double total;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
	private List<Detalle> detalles = new ArrayList<Detalle>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	
	public Factura(int numeroFactura, LocalDate fecha, double total, List<Detalle> detalles,
			Usuario usuario) {
		super();
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.total = total;
		this.detalles = detalles;
		this.usuario = usuario;
	}
	
	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double calcularTotal() {
		double sumaImportes=0;
		
		for(int i=0;i<this.detalles.size();i++) {
			sumaImportes+=this.detalles.get(i).getImporte();
		}
		
		this.total = sumaImportes;
		return this.total;
	}
	
	public void agregarDetalle(Detalle nuevoDetalle) {
		detalles.add(nuevoDetalle);
	}

	@Override
	public String toString() {
		return "Factura [N° FACTURA =" + numeroFactura + ", FECHA =" + fecha + ", Usuario=" + usuario + ", detalles=" + detalles + ", TOTAL A PAGAR= " + total + "]";
	}

	
}
