package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Usuario;

public interface IUsuarioDao {
	
	public void agregarUsuario(Usuario nuevoUsuario);
	public List<Usuario> obtenerUsuarios();
	public List<Usuario> obtenerUsuariosClientes();
	public Usuario obtenerUsuario(Long idUsuario);
	public Usuario obtenerUsuarioPorCredenciales(String email,String contra);
	
}
