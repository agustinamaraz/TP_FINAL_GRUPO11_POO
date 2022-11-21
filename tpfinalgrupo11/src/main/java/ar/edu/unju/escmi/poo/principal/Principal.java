package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import ar.edu.unju.escmi.poo.dao.IDetalleDao;
import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.dao.IProductoDao;
import ar.edu.unju.escmi.poo.dao.IRolDao;
import ar.edu.unju.escmi.poo.dao.IStockDao;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;
import ar.edu.unju.escmi.poo.dao.imp.DetalleDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.FacturaDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.RolDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.StockDaoImp;
import ar.edu.unju.escmi.poo.dao.imp.UsuarioDaoImp;
import ar.edu.unju.escmi.poo.dominio.Detalle;
import ar.edu.unju.escmi.poo.dominio.Factura;
import ar.edu.unju.escmi.poo.dominio.Producto;
import ar.edu.unju.escmi.poo.dominio.Rol;
import ar.edu.unju.escmi.poo.dominio.Usuario;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String seguir=null,email,contrasena;
		int opcion=0;
		
		// PRECARGA DE DATOS A MODO DE PRUEBA, DESCOMENTAR SI SE CREA POR PRIMERA VEZ
		
		
		/*IRolDao rolDao = new RolDaoImp();
		
		Rol r = new Rol();
		r.setDescripcion("Vendedor");
		rolDao.agregarRol(r);
		Rol r2 = new Rol();
		r2.setDescripcion("Cliente");
		rolDao.agregarRol(r2);
		
		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		
		Usuario u = new Usuario();
		u.setApellido("maraz");
		u.setNombre("agustina");
		u.setDomicilio("alto comedero");
		u.setFechaNacimiento(LocalDate.of(2003, 07, 26));
		u.setDni(44949820);
		u.setEmail("agus@com");
		u.setContrasena("123");
		u.setRol(rolDao.buscarRolPorId(1L));
		
		usuarioDao.agregarUsuario(u);
		
		Usuario u2 = new Usuario();
		u2.setApellido("fernandez");
		u2.setNombre("daiana");
		u2.setDomicilio("gorriti");
		u2.setFechaNacimiento(LocalDate.of(2003, 07, 27));
		u2.setDni(44949821);
		u2.setEmail("dai@com");
		u2.setContrasena("123");
		u2.setRol(rolDao.buscarRolPorId(2L));
		
		usuarioDao.agregarUsuario(u2);
		
		IProductoDao producto = new ProductoDaoImp();
		
		Producto p1 = new Producto();
		p1.setCategoria("fruta");
		p1.setDescripcion("banana");
		p1.setDescuento(0);
		p1.setMarca("xd");
		p1.setOrigen("argentina");
		p1.setPrecioUnitario(100);
		
		producto.agregarProducto(p1);
		
		Producto p2 = new Producto();
		p2.setCategoria("fruta");
		p2.setDescripcion("manzana");
		p2.setDescuento(0);
		p2.setMarca("zy");
		p2.setOrigen("argentina");
		p2.setPrecioUnitario(200);
		
		producto.agregarProducto(p2);*/
		
		
		IFacturaDao facturaDao = new FacturaDaoImp();
		IDetalleDao detalleDao = new DetalleDaoImp();
		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		IProductoDao productoDao = new ProductoDaoImp();
		IRolDao rolDao = new RolDaoImp();
		IStockDao stockDao = new StockDaoImp();
		
		Usuario usuario = new Usuario();
		
		
		do {
			System.out.println("\n------------------ Iniciar Sesión ----------------");
			System.out.println("Ingrese su email: ");
			email = scanner.next();
			System.out.println("Ingrese su contraseña: ");
			contrasena = scanner.next();

			usuario = usuarioDao.obtenerUsuarioPorCredenciales(email); //falta agregar contrasena en el metodo 

			if (usuario == null) {
				System.out.println("¡UPS! Usted no se encuentra registrado en el sistema");
			}else {
				System.out.println(usuario);
				
				if(usuario.getRol().getDescripcion().equals("Vendedor")) {
					do {
						System.out.println("\n------------------ MENÚ VENDEDOR ----------------");
						System.out.println("1. Alta de cliente");
						System.out.println("2. Realizar venta");
						System.out.println("3. Mostrar todos los clientes cargados");
						System.out.println("4. Mostrar todas las facturas realizadas");
						System.out.println("5. Buscar una factura por numero de factura");
						System.out.println("6. Salir");
						System.out.println("Ingrese opción: ");
						opcion = scanner.nextInt();
						
						switch (opcion) {
						case 1:
							Usuario nuevoUsuario = new Usuario();
							System.out.println("Ingrese dni");
							nuevoUsuario.setDni(scanner.nextInt());
							System.out.println("Ingrese nombre");
							nuevoUsuario.setNombre(scanner.next());
							System.out.println("Ingrese apellido");
							nuevoUsuario.setApellido(scanner.next());
							System.out.println("Ingrese domicilio");
							nuevoUsuario.setDomicilio(scanner.next());
							System.out.println("Ingrese fecha de nacimiento (dd/mm/yyyy)");
							String fechaNac = scanner.next();
							DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							nuevoUsuario.setFechaNacimiento(LocalDate.parse(fechaNac, formato));
							System.out.println("Ingrese correo electrónico");
							nuevoUsuario.setEmail(scanner.next());
							System.out.println("Ingrese contreña");
							nuevoUsuario.setContrasena(scanner.next());
							nuevoUsuario.setRol(rolDao.buscarRolPorId(2L));
							
							usuarioDao.agregarUsuario(nuevoUsuario);
							
							break;
						case 2:
							
							System.out.println("*********** LISTA DE USUARIOS PARA REALIZAR VENTA ***********");
							System.out.println(usuarioDao.obtenerUsuariosClientes());
							System.out.println("\nIngrese el Id del usuario al que desea realizar la venta: ");
							usuario = usuarioDao.obtenerUsuario(scanner.nextLong());
							
							
							Factura factura = new Factura();
							factura.setNumeroFactura((int)(Math. random()*100+1));
							factura.setUsuario(usuario);
							factura.setFecha(LocalDate.now());
							
							
							
							//List<Detalle> lineas = new ArrayList<Detalle>();
							
							do {
								
								Detalle detalle = new Detalle();
								
								detalle.setFactura(factura);
								
								System.out.println("--------------- LISTA DE PRODUCTOS A LA VENTA ---------------");
								productoDao.obtenerProductos().stream().forEach(System.out::println);
								System.out.println("\nDigite codigo del producto que desea comprar: ");
								Long codigo = scanner.nextLong();
								Producto prod = productoDao.obtenerProducto(codigo);
								
								if(prod==null) {
									System.out.println("¡¡EL CODIGO NO COINCIDE CON NINGUNO PRODUCTO!!");
								}else {
										System.out.println("¿Cuántas unidades desea comprar del producto seleccionado?");
										
										detalle.setCantidad(scanner.nextInt());
										//band = CollectionStock.decrementarStockProducto(codigo, detalle.getCantidad());
										//if(!band) {
										//	System.out.println("No hay stock suficiente o ingreso una cantidad invalida");
										//}else {
											detalle.setProducto(prod);
											detalle.setImporte(detalle.calcularImporte());
											
											//lineas.add(detalle);
											
											//factura.setDetalles(lineas);
											
											factura.agregarDetalle(detalle);
											
										
										//}
										
										System.out.println("\n\n ********************************* FACTURA **************************************");
										factura.setTotal(factura.calcularTotal());
										System.out.println(factura);
										System.out.println("\n\n");
										
										
										facturaDao.agregarFactura(factura);
										detalleDao.agregarDetalle(detalle);
								}
								
								System.out.println("\n\n¿Desea comprar otro producto? SI/NO");
								seguir = scanner.next();
							}while(seguir.equals("SI")||seguir.equals("si")||seguir.equals("s"));
							
							
							break;
						case 3:
							System.out.println(usuarioDao.obtenerUsuariosClientes());
							break;
						case 4:
							System.out.println(facturaDao.obtenerFacturas());
							break;
						case 5:
							System.out.println("Digite el numero de factura: ");
							Factura encontrada = new Factura();
							encontrada=facturaDao.buscarFacturaPorNumeroFactura(scanner.nextInt());
							if(encontrada==null){
								System.out.println("La factura ingresada no existe");
							}else {
								System.out.println(encontrada);
							}
							break;
						case 6:
							System.out.println("Usted ha salido del programa");
							break;

						default:
							System.out.println("opción incorrecta");
							break;
						}
						
					}while(opcion!=6);
				}else if(usuario.getRol().getDescripcion().equals("Cliente")){
					do {
						System.out.println("\n------------------ MENÚ CLIENTE ----------------");
						System.out.println("1. Buscar una factura por número de factura");
						System.out.println("2. Mostrar todas mis facturas");
						System.out.println("3. Salir");
						System.out.println("Ingrese opción: ");
						opcion = scanner.nextInt();
						
						switch (opcion) {
						case 1:
							
							break;
						case 2:
							
							break;
						case 3:
							System.out.println("Usted ha salido del programa");
							break;

						default:
							System.out.println("opción incorrecta");
							break;
						}
						
					}while(opcion!=3);
				}
				
			}

			System.out.println("\n¿Desea iniciar sesion nuevamente o con otro usuario? si/no");
			seguir = scanner.next();
		} while (seguir.equals("SI") || seguir.equals("si") || seguir.equals("s"));
		
		scanner.close();
	}

}
