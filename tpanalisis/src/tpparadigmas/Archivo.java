package tpparadigmas;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class Archivo {

	private String ruta;

	// Constructor
	public Archivo(String ruta) {
		this.ruta = ruta;
	}
	
	
	public HashMap<String,Atraccion> leerArchivoAtracciones()
	{
		Scanner scanner = null;
		HashMap<String,Atraccion> atracciones = null;
		
		String nombreAtr;
		int costo;
		double tiempo;
		int cupo;
		int tipo;
		
		try 
		{
			File file = new File(this.ruta);
			scanner = new Scanner(file);
			
			
			while(scanner.hasNext())
			{
				nombreAtr = scanner.nextLine();
				costo = scanner.nextInt();
				tiempo = scanner.nextDouble();
				cupo = scanner.nextInt();
				tipo = scanner.nextInt();
				
				Atraccion atraccionAct = new Atraccion(costo,tiempo,cupo,tipo);			
				atracciones.put(nombreAtr, atraccionAct);
			}				
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar el archivo, eso es mucho muy importante
			scanner.close();
		}
		return atracciones;
	}
	
	public LinkedList<Promocion> leerArchPromociones()
	{
		Scanner scanner = null;
		LinkedList<Promocion> listaPromociones = null;
		int tipoPaquete;
		int tipoAtraccion;
		int precioFinal;
		
		
		try {
			File file = new File(this.ruta);
			scanner = new Scanner(file);
			
			tipoPaquete = scanner.nextInt();
			tipoAtraccion = scanner.nextInt();
			
			
			switch(tipoPaquete)
			{
				case 1:
					precioFinal = scanner.nextInt();
					break;
				
				case 2:
					precioFinal = scanner.nextInt();
					break;
				
				
			
			}
				

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar el archivo, eso es mucho muy importante
			scanner.close();
		}

		return listaPromociones;
		
	}
}
