package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.dominio.Stock;

public interface IStockDao {
	public void agregarStock(Stock Stock);
	public Stock buscarStockPorId(Long id);
	public Stock buscarStockPorIdProducto(Long idProducto);
	public boolean decrementarStock(Stock stock,int cantidad);
}
