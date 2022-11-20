package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IRolDao;
import ar.edu.unju.escmi.poo.dominio.Rol;

public class RolDaoImp implements IRolDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public List<Rol> buscarRoles() {
		// TODO Auto-generated method stub
		return null;
		//return manager.createQuery("SELECT ");
	}

	@Override
	public Rol buscarRolPorId(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Rol.class,id);
	}

	@Override
	public void agregarRol(Rol rol) {
		try {
			manager.getTransaction().begin();
			manager.persist(rol);
			manager.getTransaction().commit();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
