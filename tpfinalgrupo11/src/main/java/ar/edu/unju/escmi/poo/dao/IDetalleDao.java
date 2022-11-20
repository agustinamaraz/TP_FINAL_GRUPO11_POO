package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.dominio.Detalle;

public interface IDetalleDao {
	public void agregarDetalle(Detalle nuevoDetalle);
	public void eliminarDetalle(Detalle detalle);
}
