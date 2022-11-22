package ar.edu.unju.escmi.poo.dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.dao.IProductoDao;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoImp;


class DetalleTest {
	IProductoDao productoDao = new ProductoDaoImp();
	List<Detalle> detalles;
	Producto producto;
	
	@BeforeEach
	void setUp() throws Exception {
		detalles = new ArrayList<Detalle>();
		producto = new Producto();
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalcularImporte() {
		
		producto = productoDao.obtenerProducto(12L);
		detalles.add(new Detalle(4,producto,producto.getPrecioUnitario()*4));

		assertTrue(30000*4 == detalles.get(0).getImporte());
		
	}

}
