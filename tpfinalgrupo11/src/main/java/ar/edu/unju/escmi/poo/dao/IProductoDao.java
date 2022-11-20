package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Producto;

public interface IProductoDao {
	public void agregarProducto(Producto nuevoProducto);
	public void eliminarProducto(Producto producto);
	public List<Producto> obtenerProductos();
	public Producto obtenerProducto(Long idProducto);
}
