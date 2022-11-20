package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Rol;

public interface IRolDao {
	public void agregarRol(Rol rol);
	public List<Rol> buscarRoles();
	public Rol buscarRolPorId(Long id);
}
