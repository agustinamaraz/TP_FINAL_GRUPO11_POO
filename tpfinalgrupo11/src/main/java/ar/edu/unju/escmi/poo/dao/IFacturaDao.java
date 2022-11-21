package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Factura;

public interface IFacturaDao {
	
	public void agregarFactura(Factura nuevaFactura);
	public Factura buscarFacturaPorNumeroFactura(int nroFactura);
	public List<Factura> obtenerFacturas();
	
}
