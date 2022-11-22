package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.NoResultException;

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
import ar.edu.unju.escmi.poo.dominio.Stock;
import ar.edu.unju.escmi.poo.dominio.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		IRolDao rolDao = new RolDaoImp();
		IProductoDao productoDao = new ProductoDaoImp();
		IStockDao stockDao = new StockDaoImp();
		IFacturaDao facturaDao = new FacturaDaoImp();
		IDetalleDao detalleDao = new DetalleDaoImp();
		
		/*
		  
		// PRECARGA DE ROLES
		
		Rol rolVendedor = new Rol();
		rolVendedor.setDescripcion("Vendedor");
		rolDao.agregarRol(rolVendedor);
		Rol rolCliente = new Rol();
		rolCliente.setDescripcion("Cliente");
		rolDao.agregarRol(rolCliente);
	
		// PRECARGA DE PRODUCTOS
		
		Producto producto1 = new Producto("Heladera","2 PUERTAS COLOR BLANCA - VERSIÓN INVERTER",60000.0,"ARGENTINA","LG",0);
		Producto producto2 = new Producto("Heladera","CICLICA",30000.0,"CHIINA","SAMSUNG",0);
		Producto producto3 = new Producto("Heladera","NO FROST",22200.0,"PERU","CANON",0);
		Producto producto4 = new Producto("Heladera","Heladera con Freezer 414 lts acero",40000.0,"CHILE","BRIKET",0);
		Producto producto5 = new Producto("Televisor","TV MOTOROLA 50",30000.0,"ARGENTINA","LG",25);
		Producto producto6 = new Producto("Televisor","TV.LED 55",49999.0,"PARAGUAY","NOKIA",0);
		Producto producto7 = new Producto("Televisor","TV.LED 873",55000.0,"ARGENTINA","LG",0);
		Producto producto8 = new Producto("Televisor","Smart TV 4K 50",20000.0,"ARGENTINA","LG",0);
		Producto producto9 = new Producto("Lavarropas","Lavarropas semi 7 kgs",20000.0,"BOLIVIA","BRIKET",0);
		Producto producto10 = new Producto("Lavarropas","NEXT 10·12 P ECO",30000.0,"ARGENTINA","LILIANA",30);
		Producto producto11 = new Producto("Lavarropas","LAVARROPAS CARGA SUPERIOR DIGI FIT BLANCO",40000.0,"CHILE","BRIKET",25);
		Producto producto12 = new Producto("Lavarropas","LAVARROPAS CARGA SUPERIOR GAFA FUZZY FIT PLATA",55000.0,"CHINA","Samsung",0);
		Producto producto13 = new Producto("Celular","SM-A325/4+128",25000.0,"CHINA","XIAOMI",25);
		Producto producto14 = new Producto("Celular","Moto G52 Negro Azul",30200.0,"ARGENTINA","Motorola",30);
		Producto producto15 = new Producto("Celular","Smartphone 6",60000.0,"CHINA","Samsung",0);
		Producto producto16 = new Producto("Celular","Moto G41 Negro Onix",70000.0,"JAPON","Motorola",25);
		productoDao.agregarProducto(producto1);
		productoDao.agregarProducto(producto2);
		productoDao.agregarProducto(producto3);
		productoDao.agregarProducto(producto4);
		productoDao.agregarProducto(producto5);
		productoDao.agregarProducto(producto6);
		productoDao.agregarProducto(producto7);
		productoDao.agregarProducto(producto8);
		productoDao.agregarProducto(producto9);
		productoDao.agregarProducto(producto10);
		productoDao.agregarProducto(producto11);
		productoDao.agregarProducto(producto12);
		productoDao.agregarProducto(producto13);
		productoDao.agregarProducto(producto14);
		productoDao.agregarProducto(producto15);
		productoDao.agregarProducto(producto16);
		
		//PRECARGA DE STOCKS
		
		Stock stock1 = new Stock(100,productoDao.obtenerProducto(17L));
		Stock stock2 = new Stock(100,productoDao.obtenerProducto(18L));
		Stock stock3 = new Stock(100,productoDao.obtenerProducto(3L));
		Stock stock4 = new Stock(100,productoDao.obtenerProducto(4L));
		Stock stock5 = new Stock(100,productoDao.obtenerProducto(5L));
		Stock stock6 = new Stock(100,productoDao.obtenerProducto(6L));
		Stock stock7 = new Stock(100,productoDao.obtenerProducto(7L));
		Stock stock8 = new Stock(100,productoDao.obtenerProducto(8L));
		Stock stock9 = new Stock(100,productoDao.obtenerProducto(9L));
		Stock stock10 = new Stock(100,productoDao.obtenerProducto(10L));
		Stock stock11 = new Stock(100,productoDao.obtenerProducto(11L));
		Stock stock12 = new Stock(100,productoDao.obtenerProducto(12L));
		Stock stock13 = new Stock(100,productoDao.obtenerProducto(13L));
		Stock stock14 = new Stock(100,productoDao.obtenerProducto(14L));
		Stock stock15 = new Stock(100,productoDao.obtenerProducto(15L));
		Stock stock16 = new Stock(100,productoDao.obtenerProducto(16L));
		stockDao.agregarStock(stock1);
		stockDao.agregarStock(stock2);
		stockDao.agregarStock(stock3);
		stockDao.agregarStock(stock4);
		stockDao.agregarStock(stock5);
		stockDao.agregarStock(stock6);
		stockDao.agregarStock(stock7);
		stockDao.agregarStock(stock8);
		stockDao.agregarStock(stock9);
		stockDao.agregarStock(stock10);
		stockDao.agregarStock(stock11);
		stockDao.agregarStock(stock12);
		stockDao.agregarStock(stock13);
		stockDao.agregarStock(stock14);
		stockDao.agregarStock(stock15);
		stockDao.agregarStock(stock16);
		
		
		// PRECARGA DE USUARIO VENDEDOR
		
		Usuario vendedor = new Usuario(44949820,"maraz","agustina","alto comedero",LocalDate.of(2003, 07, 26),
		"agus@com","123",rolDao.buscarRolPorId(1L));
		usuarioDao.agregarUsuario(vendedor);
		
		*/
		
		
		Usuario usuario = new Usuario();
		Scanner scanner = new Scanner(System.in);
		String email,contrasena,seguir;
		int opcion=0;
		boolean error,repetido;
		
		do {
			System.out.println("\n------------------ Iniciar Sesión ----------------");
			System.out.println("Ingrese su email: ");
			email = scanner.next();
			System.out.println("Ingrese su contraseña: ");
			contrasena = scanner.next();
			try {
				usuario = usuarioDao.obtenerUsuarioPorCredenciales(email,contrasena);
				
				
				if(usuario.getRol().getDescripcion().equals("Vendedor")) {
					do {
						error=false;
						try {
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
								do {
									error=false;
									try {
										System.out.println("Ingrese dni");
										nuevoUsuario.setDni(scanner.nextInt());
									}catch(InputMismatchException ime) {
										System.out.println("¡Error! No ingrese letras o palabras");
										error=true;
										scanner.next();
									}
								}while(error==true);
								
								System.out.println("Ingrese nombre");
								nuevoUsuario.setNombre(scanner.next());
								System.out.println("Ingrese apellido");
								nuevoUsuario.setApellido(scanner.next());
								System.out.println("Ingrese domicilio");
								nuevoUsuario.setDomicilio(scanner.next());
								
								do {
									error=false;
									try {
										System.out.println("Ingrese fecha de nacimiento (dd/mm/yyyy)");
										String fechaNac = scanner.next();
										DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
										nuevoUsuario.setFechaNacimiento(LocalDate.parse(fechaNac, formato));
									}catch(DateTimeParseException dtpe) {
										System.out.println("¡Error! Ingrese la fecha con el formato: dd/MM/yyyy");
										error=true;
									}
								}while(error==true);
								do {
									repetido=false;
									System.out.println("Ingrese correo electrónico");
									nuevoUsuario.setEmail(scanner.next());
									
									for(int i=0;i<usuarioDao.obtenerUsuarios().size();i++) {
										if(nuevoUsuario.getEmail().equals(usuarioDao.obtenerUsuarios().get(i).getEmail())) {
											repetido=true;
										}
									}
									
									if(repetido==true) {
										System.out.println("Email ya registrado, ingrese uno distinto");
									}
									
								}while(repetido==true);
								
			
								System.out.println("Ingrese contreña");
								nuevoUsuario.setContrasena(scanner.next());
								nuevoUsuario.setRol(rolDao.buscarRolPorId(2L));
								
								usuarioDao.agregarUsuario(nuevoUsuario);
								
								break;
							case 2:
							
								Factura factura = new Factura();
								factura.setNumeroFactura((int)(Math. random()*100+1));
								factura.setFecha(LocalDate.now());
								System.out.println("*********** LISTA DE USUARIOS PARA REALIZAR VENTA ***********");
								System.out.println(usuarioDao.obtenerUsuariosClientes());
								System.out.println("\nIngrese el Id del usuario al que desea realizar la venta: ");
								
								do {
									usuario = usuarioDao.obtenerUsuario(scanner.nextLong());
									if(usuario==null) {
										System.out.println("Id no encontrado, intente con otro");
									}
								}while(usuario==null);
								
								
								factura.setUsuario(usuario);
								int cantidad;
								
								do {
									
									Detalle detalle = new Detalle();
									
									detalle.setFactura(factura);
									
									System.out.println("--------------- LISTA DE PRODUCTOS A LA VENTA ---------------");
									productoDao.obtenerProductos().stream().forEach(System.out::println);
									System.out.println("\nDigite el ID del producto que desea comprar: ");
									Long idProducto = scanner.nextLong();
									Producto prod = productoDao.obtenerProducto(idProducto);
									
									if(prod==null) {
										System.out.println("¡¡EL CODIGO NO COINCIDE CON NINGUNO PRODUCTO!!");
									}else {
										
											do {
												System.out.println("¿Cuántas unidades desea comprar del producto seleccionado? INGRESE CANTIDAD VALIDA");
												cantidad=scanner.nextInt();
												detalle.setCantidad(cantidad);
											}while(cantidad<0);
											
											
											Stock stock = stockDao.buscarStockPorIdProducto(idProducto);
											boolean band = stockDao.decrementarStock(stock, cantidad);
											
											if(!band) {
												System.out.println(stock);
												System.out.println("No hay stock suficiente del producto seleccionado");
											}else {
											
												detalle.setProducto(prod);
												
												switch(prod.getDescuento()) {
													case 0:
														detalle.setImporte(detalle.calcularImporte());
														break;
													case 25:
														detalle.setImporte(detalle.calcularImporte()*0.25);
														break;
													case 30:
														detalle.setImporte(detalle.calcularImporte()*0.3);
														break;
												}
												
												
												factura.agregarDetalle(detalle);
												
												System.out.println("\n\n ********************************* FACTURA **************************************");
												factura.setTotal(factura.calcularTotal());
												
												System.out.println(factura);
												System.out.println("\n");
												
												
												facturaDao.agregarFactura(factura);
												facturaDao.modificarFactura(factura); // necesario para que no salte una excepcion debido a la siguiente linea
												detalleDao.agregarDetalle(detalle);
											}
											
											
									}
									
									
									System.out.println("\n¿Desea comprar otro producto? SI/NO");
									seguir = scanner.next();
								}while(seguir.equals("SI")||seguir.equals("si")||seguir.equals("s"));
								
								int pago=0;
								
								do {
									error=false;
									try {
										System.out.println("Total a pagar: "+factura.getTotal());
										System.out.println("Digite la cantidad que va a abonar en efectivo: ");
										pago = scanner.nextInt();
										
										if(pago==factura.getTotal()) {
											System.out.println("\n\n********************************* FACTURA **************************************");
											System.out.println(factura);
											System.out.println("************************************* PAGADO ************************************");
										}else {
											System.out.println("\n¡Ingrese la cantidad justa de dinero para pagar la factura!\n");
										}
									}catch(InputMismatchException ime) {
										System.out.println("¡Error! No ingrese letras o palabras");
										error=true;
										scanner.next();
									}
									
								}while(pago<factura.getTotal()||pago>factura.getTotal()||error==true);
							
								break;
							case 3:
								if(usuarioDao.obtenerUsuariosClientes()==null) {
									System.out.println("No hay clientes cargados");
								}else {
									System.out.println(usuarioDao.obtenerUsuariosClientes());
								}
								break;
							case 4:
								try {
									System.out.println(facturaDao.obtenerFacturas());
								}catch(Exception e) {
									System.out.println("No hay facturas realizadas");
								}
								break;
							case 5:
								try{
									System.out.println("Digite el numero de factura: ");
									System.out.println(facturaDao.buscarFacturaPorNumeroFactura(scanner.nextInt()));
								}catch(Exception e){
									System.out.println("La factura ingresada no existe");
								}
								break;
							case 6:
								System.out.println("Usted ha salido del programa");
								break;

							default:
								System.out.println("opción incorrecta");
								break;
							}
						}catch(InputMismatchException ime) {
							System.out.println("¡Error! No ingrese letras o palabras");
							error=true;
							scanner.next();
						}
						
						
					}while(opcion!=6 || error==true);
				}else if(usuario.getRol().getDescripcion().equals("Cliente")){
					do {
						error=false;
						try {
							System.out.println("\n------------------ MENÚ CLIENTE ----------------");
							System.out.println("1. Buscar una de mis factura por número de factura");
							System.out.println("2. Mostrar todas mis facturas");
							System.out.println("3. Salir");
							System.out.println("Ingrese opción: ");
							opcion = scanner.nextInt();
							
							switch (opcion) {
							case 1:
								System.out.println("Digite su número de factura: ");
								Factura factura = facturaDao.obtenerFacturaPorIdYNumeroFactura(usuario.getIdUsuario(), scanner.nextInt());
								if(factura==null) {
									System.out.println("No se encontró su factura");
								}else {
									System.out.println(factura);
								}
								
								break;
							case 2:
								System.out.println(facturaDao.obtenerFacturasPorId(usuario.getIdUsuario()));
								break;
							case 3:
								System.out.println("Usted ha salido del programa");
								break;

							default:
								System.out.println("opción incorrecta");
								break;
							}
						}catch(InputMismatchException ime) {
							System.out.println("¡Error! No ingrese letras o palabras");
							error=true;
							scanner.next();
						}
						
						
					}while(opcion!=3 || error==true);
				}
				
				
			}catch(NoResultException nre) {
				System.out.println("¡UPS! Usted no se encuentra registrado en el sistema\nCorreo o contraseña inválidos");
			}
			
			
			
			System.out.println("\n¿Desea iniciar sesion nuevamente o con otro usuario? si/no");
			seguir = scanner.next();
		} while (seguir.equals("SI") || seguir.equals("si") || seguir.equals("s"));
		
		scanner.close();
	}

}
