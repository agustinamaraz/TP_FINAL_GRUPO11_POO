package ar.edu.unju.escmi.poo.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IStockDao;
import ar.edu.unju.escmi.poo.dominio.Stock;

public class StockDaoImp implements IStockDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void agregarStock(Stock Stock) {
		try {
			manager.getTransaction().begin();
			manager.persist(Stock);
			manager.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Stock buscarStockPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock buscarStockPorIdProducto(Long idProducto) {
		Query query = manager.createQuery("SELECT s FROM Stock s WHERE s.producto.idProducto = :idProducto");
		query.setParameter("idProducto", idProducto);
		Stock stock = (Stock)query.getSingleResult();
		return stock;
	}

	@Override
	public boolean decrementarStock(Stock stock, int cantidad) {
		if(stock.getCantidad()-cantidad >= 0) {
			stock.setCantidad(stock.getCantidad()-cantidad);
			
			manager.getTransaction().begin();
			manager.merge(stock);
			manager.getTransaction().commit();
			return true;
		}else {
			return false;
		}
	
	}

}
