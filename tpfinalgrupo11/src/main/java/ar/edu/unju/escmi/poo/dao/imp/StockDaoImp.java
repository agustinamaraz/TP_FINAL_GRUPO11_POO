package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

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
	public List<Stock> buscarStocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock buscarStockPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
