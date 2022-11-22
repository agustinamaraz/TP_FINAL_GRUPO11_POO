package ar.edu.unju.escmi.poo.dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dao.IProductoDao;
import ar.edu.unju.escmi.poo.dao.IRolDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.RolDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;

class FacturaTest {
	IFacturaDao facturaDao = new FacturaDaoImp();
	IUsuarioDao usuarioDao = new UsuarioDaoImp();
	IRolDao rolDao = new RolDaoImp();
	IProductoDao productoDao = new ProductoDaoImp();
	
	Factura factura;
	List<Detalle> detalles;
	Usuario usuario;
	Producto producto;
	
	@BeforeEach
	void setUp() throws Exception {
		factura = new Factura();
		usuario = new Usuario();
		detalles = new ArrayList<Detalle>();
		producto = new Producto();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalcularTotal() {
		usuario = usuarioDao.obtenerUsuario(2L);
		factura.setNumeroFactura(258);
		factura.setFecha(LocalDate.now());
		Rol rol = new Rol();
		rol.setDescripcion(rolDao.buscarRolPorId(2L).getDescripcion());
		factura.setUsuario(usuario);
		producto = productoDao.obtenerProducto(10L);
		detalles.add(new Detalle(3,producto,producto.getPrecioUnitario()*3));
		factura.setDetalles(detalles);
		
		double obtenido = factura.calcularTotal();

		assertTrue(obtenido != 0);
	}

}
