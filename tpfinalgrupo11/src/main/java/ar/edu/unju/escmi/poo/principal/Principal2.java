package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IDetalleDao;
import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dao.IProductoDao;
import ar.edu.unju.escmi.poo.dao.IRolDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.DetalleDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.RolDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;
import ar.edu.unju.escmi.poo.dominio.Detalle;
import ar.edu.unju.escmi.poo.dominio.Factura;
import ar.edu.unju.escmi.poo.dominio.Producto;
import ar.edu.unju.escmi.poo.dominio.Rol;
import ar.edu.unju.escmi.poo.dominio.Usuario;

public class Principal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		IDetalleDao detalles = new DetalleDaoImp();
		
		//List<Detalle> lineas = new ArrayList<>();
		
		
		IProductoDao productos = new ProductoDaoImp();
		//for(int i=0;i<10;i++) {
			Detalle linea = new Detalle();
			linea.setFactura(factura);
			linea.setCantidad(1);
			linea.setImporte(100);
			linea.setProducto(new Producto("uva","samsung","argentina","fruta",0,99.6));
			productos.agregarProducto(linea.getProducto());
			
			factura.agregarDetalle(linea);
			detalles.agregarDetalle(linea);
			
			linea.setFactura(factura);
			linea.setCantidad(2);
			linea.setImporte(200);
			linea.setProducto(new Producto("pera","nokia","argentina","fruta",0,100.6));
			productos.agregarProducto(linea.getProducto());
			
			factura.agregarDetalle(linea);
			detalles.agregarDetalle(linea);
		//}
		
		IUsuarioDao usuarios = new UsuarioDaoImp();
		
		Usuario usuario = new Usuario();
		usuario.setApellido("maraz");
		usuario.setContrasena("123");
		usuario.setDni(44949825);
		usuario.setDomicilio("palpala");
		usuario.setEmail("mvp");
		usuario.setFechaNacimiento(LocalDate.now());
		usuario.setNombre("joaqui");
		
		IRolDao roles = new RolDaoImp();
		usuario.setRol(roles.buscarRolPorId(2L));
		roles.agregarRol(usuario.getRol());
		
		usuarios.agregarUsuario(usuario);
		
		IFacturaDao facturas = new FacturaDaoImp();
		facturas.agregarFactura(factura);
		
	}

}
