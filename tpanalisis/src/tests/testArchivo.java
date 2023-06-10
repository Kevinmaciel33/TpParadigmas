package tests;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import tpparadigmas.Archivo;
import tpparadigmas.Atraccion;
import tpparadigmas.Producto;
import tpparadigmas.Promocion;
import tpparadigmas.Usuario;

public class testArchivo {

//	@Test
//	public void abrirArchivoAtracciones() 
//	{
//		Archivo archAtracciones = new Archivo("Atracciones.txt");		
//		LinkedList<Atraccion> listaAtracc = archAtracciones.leerArchivoAtracciones();
//	
//	}

	
//	@Test
//	public void abrirArchivoPromociones() 
//	{
//		Archivo archAtracciones = new Archivo("Atracciones.txt");		
//		LinkedList<Atraccion> listaAtracc = archAtracciones.leerArchivoAtracciones();
//		
//		//System.out.println(listaAtracc);
//		
//		Archivo archPromociones = new Archivo("Paquetes.txt");		
//		LinkedList<Promocion> listaPromociones = archPromociones.leerArchivoPromociones(listaAtracc);
//		
//		System.out.println(listaPromociones);
//	}
	
	@Test
	public void abrirArchivoUsuarios() 
	{
		Archivo archUsuarios = new Archivo("Cliente.txt");		
		LinkedList<Usuario> listaUsuarios = archUsuarios.leerArchivoUsuarios();
		
		System.out.println(listaUsuarios);
	}
}
