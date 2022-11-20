package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dominio.Usuario;

public class UsuarioDaoImp implements IUsuarioDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void agregarUsuario(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub
		try {
			manager.getTransaction().begin();
			manager.persist(nuevoUsuario);
			manager.getTransaction().commit();	
		}catch(Exception e) {
			System.out.println(e);
		}
			
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();	
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) manager.createQuery("SELECT u FROM Usuario u").getResultList();
		return usuarios;
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();	
	}

	@Override
	public Usuario obtenerUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		return manager.find(Usuario.class, idUsuario);
	}

	@Override
	public Usuario obtenerUsuarioPorCredenciales(String email) {
		@SuppressWarnings("unchecked")
		Query query = manager.createQuery("SELECT u FROM Usuario u " + "WHERE u.email = :email");
		query.setParameter("email", email);
		Usuario usuario = (Usuario) query.getSingleResult();
		return usuario;
	}

}
