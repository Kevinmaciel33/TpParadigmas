package tpparadigmas;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Archivo archAtracciones = new Archivo("Atracciones.txt");		
		LinkedList<Atraccion> listaAtracc = archAtracciones.leerArchivoAtracciones();
		
		
		Archivo archPromociones = new Archivo("Paquetes.txt");		
		LinkedList<Promocion> listaPromociones = archPromociones.leerArchivoPromociones(listaAtracc);
		
		Archivo archUsuarios = new Archivo("Cliente.txt");		
		LinkedList<Usuario> listaUsuarios = archUsuarios.leerArchivoUsuarios();
		
		
		//Lista con atracciones/promociones que viene de archivo, sin ordenar
		
		
		LinkedList<Producto> listaOriginal = new LinkedList<Producto>();
		
		
		//En la lista original mezclo las lists de atracciones y promociones
		
		listaOriginal.addAll(listaAtracc);
		listaOriginal.addAll(listaPromociones);		
		
		//Lote de prueba generico
//		listaOriginal.add(new Atraccion("At1", 100, 5, TipoAtraccion.Paisaje, 9));
//		listaOriginal.add(new Atraccion("At2", 300, 2, TipoAtraccion.Degustacion, 9));
//		listaOriginal.add(new Atraccion("At3", 300, 4, TipoAtraccion.Aventura, 9));
		
		System.out.println(listaOriginal);
		Collections.sort(listaOriginal);
		System.out.println(listaOriginal);
		
		//Listas para mostrar al usuario en base a sus preferencias
		LinkedList<Producto> listaOrdAventura = new LinkedList<Producto>();
		LinkedList<Producto> listaOrdPaisaje = new LinkedList<Producto>();
		LinkedList<Producto> listaOrdDegustacion = new LinkedList<Producto>();
		
		listaOrdAventura 	= Stream.concat(listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion == TipoAtraccion.Aventura), 
													listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion != TipoAtraccion.Aventura)).collect(Collectors.toCollection(LinkedList::new));
		
		listaOrdPaisaje 	= Stream.concat(listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion == TipoAtraccion.Paisaje),
													listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion != TipoAtraccion.Paisaje)).collect(Collectors.toCollection(LinkedList::new));
		
		listaOrdDegustacion = Stream.concat(listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion == TipoAtraccion.Degustacion),
													listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion != TipoAtraccion.Degustacion)).collect(Collectors.toCollection(LinkedList::new));	
	

	for(Usuario usuario:listaUsuarios){
			TipoAtraccion tipoPref = usuario.getPreferencia();
			LinkedList<Producto> listaPref;

			switch (tipoPref) {
			case Aventura:
				listaPref = listaOrdAventura;
				break;
			case Paisaje:
				listaPref = listaOrdPaisaje;
				break;
			case Degustacion:
				listaPref = listaOrdDegustacion;
				break;
			default:
				listaPref = listaOriginal;
				break;
			}

	
			LinkedList<Producto> atraccionesAceptadas = new LinkedList<>();
			int gastoTotal = 0;
			double tiempoTotal = 0;
	
			for (Producto producto : listaPref) {
				if (producto.sinCupo())
					continue; 
				
			
			if (producto instanceof Promocion) {
				Promocion promocion = (Promocion) producto;
				if (!promocion.tieneCupo() || (promocion.getAtracciones().stream().anyMatch(atraccion -> atraccionesAceptadas.contains(atraccion)))) {
					continue;
				}
			} else {
				Atraccion atraccion = (Atraccion) producto;
				if (atraccionesAceptadas.contains(atraccion))
					continue; 
				}
			
			
			
			if (usuario.tienePresupuestoSuficiente(producto.getCosto()) && usuario.tieneTiempoDisponibleSuficiente(producto.getTiempo())) {
	
				try (Scanner scanner = new Scanner(System.in)) {
					String respuesta;
					do{
					System.out.println("¿Te gustaría realizar la compra de " + producto.getNombre() + "? (Y/N)");
					respuesta = scanner.nextLine();
					
					if (respuesta.equalsIgnoreCase("Y")) {
						usuario.restarPresupuesto(producto.getCosto());
						usuario.restarTiempoDisponible(producto.getTiempo());

						if (producto instanceof Promocion) {
							Promocion promocion = (Promocion) producto;
							atraccionesAceptadas.addAll(promocion.atracciones);
						}
						else atraccionesAceptadas.add(producto);

						gastoTotal += producto.getTiempo();
						tiempoTotal += producto.getCosto();


						System.out.println("Compra realizada con éxito!");
						}
					
					System.out.println("Presupuesto restante: " + usuario.getPresupuesto());
					System.out.println("Tiempo restante: " + usuario.getTiempoDisponible());
					
					}while(!respuesta.equalsIgnoreCase("Y") || !respuesta.equalsIgnoreCase("N"));
				}
	
			}
	
				if (gastoTotal > 0 || tiempoTotal > 0) {
				System.out.println("----- Itinerario -----");
				System.out.println("Atracciones compradas: ");
				for (Producto atraccion : atraccionesAceptadas) {
					System.out.println(atraccion);
					}
				System.out.println("Costo total: " + gastoTotal);
				System.out.println("Tiempo total: " + tiempoTotal);
				}
		}
	
	
	
	}
}
}