package ar.edu.unju.escmi.poo.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.dao.IRolDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.RolDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;

class UsuarioTest {
	IUsuarioDao usuarioDao = new UsuarioDaoImp();
	IRolDao rolDao = new RolDaoImp();
	Usuario usuario;
	Rol rol;
	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario();
		rol = new Rol();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testVerificarRolAsignado() {
		rol = rolDao.buscarRolPorId(1L);
		usuario.setRol(rol);
		
		assertTrue("Vendedor".equals(usuario.getRol().getDescripcion()));
	}

}
