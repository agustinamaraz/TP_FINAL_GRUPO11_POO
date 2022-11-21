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

}
