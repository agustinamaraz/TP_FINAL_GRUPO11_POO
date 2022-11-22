package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IProductoDao;
import ar.edu.unju.escmi.poo.dominio.Producto;


public class ProductoDaoImp implements IProductoDao{
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void agregarProducto(Producto nuevoProducto) {
		try{
			manager.getTransaction().begin();
			manager.persist(nuevoProducto);
			manager.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public List<Producto> obtenerProductos() {
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>) manager.createQuery("SELECT p FROM Producto p").getResultList();
		return productos;
	}

	@Override
	public Producto obtenerProducto(Long idProducto) {
		return manager.find(Producto.class, idProducto);
	}

}
