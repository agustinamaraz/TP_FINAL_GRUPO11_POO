package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dominio.Factura;
import ar.edu.unju.escmi.poo.config.EmfSingleton;

public class FacturaDaoImp implements IFacturaDao{
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void agregarFactura(Factura nuevaFactura) {
		try {
			manager.getTransaction().begin();
			manager.persist(nuevaFactura);
			manager.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Factura buscarFacturaPorNumeroFactura(int nroFactura) {
		Query query = manager.createQuery("SELECT f FROM Factura f" + " WHERE f.numeroFactura = :nroFactura");
		query.setParameter("nroFactura", nroFactura);
		Factura factura = (Factura) query.getSingleResult();
		return factura;
	}

	@Override
	public List<Factura> obtenerFacturas(){
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Factura> facturas = (List<Factura>) manager.createQuery("SELECT f FROM Factura f").getResultList();
		return facturas;
	}

	@Override
	public List<Factura> obtenerFacturasPorId(Long id) {
		Query query = manager.createQuery("SELECT f FROM Factura f WHERE f.usuario.idUsuario = :id");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Factura> facturas = (List<Factura>) query.getResultList();
		return facturas;
	}

	@Override
	public Factura obtenerFacturaPorIdYNumeroFactura(Long id, int nroFactura) {
		Query query = manager.createQuery("SELECT f FROM Factura f WHERE f.usuario.idUsuario = :id AND f.numeroFactura = :nroFactura");
		query.setParameter("id", id);
		query.setParameter("nroFactura", nroFactura);
		Factura factura = (Factura) query.getSingleResult();
		return factura;
	}

	@Override
	public void eliminarFactura(Factura factura) {
		manager.getTransaction().begin();
		manager.remove(factura);
		manager.getTransaction().commit();
	}

	@Override
	public void modificarFactura(Factura factura) {
		manager.getTransaction().begin();
		manager.merge(factura);
		manager.getTransaction().commit();
	}

}
