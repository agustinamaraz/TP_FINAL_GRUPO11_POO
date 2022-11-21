package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Stock;

public interface IStockDao {
	public void agregarStock(Stock Stock);
	public List<Stock> buscarStocks();
	public Stock buscarStockPorId(Long id);
}
