package ar.edu.unju.escmi.poo.dao.imp;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IDetalleDao;
import ar.edu.unju.escmi.poo.dominio.Detalle;

public class DetalleDaoImp implements IDetalleDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void agregarDetalle(Detalle nuevoDetalle) {
		//7try {
			manager.getTransaction().begin();
			manager.persist(nuevoDetalle);
			manager.getTransaction().commit();
		//}catch(Exception e) {
			//System.out.println(e);
		//}
		
	}

	@Override
	public void eliminarDetalle(Detalle detalle) {
		manager.getTransaction().begin();
		manager.remove(detalle);
		manager.getTransaction().commit();
	}

}
