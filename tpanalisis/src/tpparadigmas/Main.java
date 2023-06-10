package tpparadigmas;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		//Lista con atracciones/promociones que viene de archivo, sin ordenar
		LinkedList<Producto> listaOriginal = new LinkedList<Producto>();
		
		//Lote de prueba generico
		listaOriginal.add(new Atraccion("At1", 100, 5, TipoAtraccion.Paisaje, 9));
		listaOriginal.add(new Atraccion("At2", 300, 2, TipoAtraccion.Degustacion, 9));
		listaOriginal.add(new Atraccion("At3", 300, 4, TipoAtraccion.Aventura, 9));
		
		System.out.println(listaOriginal);
		Collections.sort(listaOriginal);
		System.out.println(listaOriginal);
		
		//Listas para mostrar al usuario en base a sus preferencias
		LinkedList<Producto> ofrecerAUsuariosAventura = new LinkedList<Producto>();
		LinkedList<Producto> ofrecerAUsuariosPaisaje = new LinkedList<Producto>();
		LinkedList<Producto> ofrecerAUsuariosDegustacion = new LinkedList<Producto>();
		
		ofrecerAUsuariosAventura = Stream.concat(listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion == TipoAtraccion.Aventura), listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion != TipoAtraccion.Aventura)).collect(Collectors.toCollection(LinkedList::new));
		ofrecerAUsuariosPaisaje = Stream.concat(listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion == TipoAtraccion.Paisaje), listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion != TipoAtraccion.Paisaje)).collect(Collectors.toCollection(LinkedList::new));
		ofrecerAUsuariosDegustacion = Stream.concat(listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion == TipoAtraccion.Degustacion), listaOriginal.stream().filter(elemento -> elemento.tipoAtraccion != TipoAtraccion.Degustacion)).collect(Collectors.toCollection(LinkedList::new));
		
		
	}

}
