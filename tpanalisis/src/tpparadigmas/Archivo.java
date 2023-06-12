package tpparadigmas;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Archivo {

	private String ruta;

	// Constructor
	public Archivo(String ruta) {
		this.ruta = ruta;
	}
	
	
	public LinkedList<Atraccion> leerArchivoAtracciones()
	{
		Scanner scanner = null;
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		
		String nombreAtr;
		int costo;
		double tiempo;
		int cupo;
		String nombreTipoAtraccion;
		
		try 
		{
			File file = new File(this.ruta);
			scanner = new Scanner(file);
			
			
			while(scanner.hasNext())
			{
				nombreAtr = scanner.next();
				costo = scanner.nextInt();
				tiempo = scanner.nextDouble();
				cupo = scanner.nextInt();
				nombreTipoAtraccion = scanner.next();
				
				Atraccion atraccionAct = new Atraccion(nombreAtr,costo,tiempo,TipoAtraccion.asignarTipo(nombreTipoAtraccion),cupo);			
				atracciones.add(atraccionAct);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return atracciones;
	}
	
	public LinkedList<Promocion> leerArchivoPromociones(LinkedList<Atraccion>listaAtracciones)
	{
		LinkedList<Promocion> listaProds = new LinkedList<Promocion>();		
		Scanner scanner = null;
		int tipoPaquete;
		String nombrePaquete;
		String nombreTipoAtraccion;
		int cantAtracciones;
		TipoAtraccion tipo = null;	
		String nombreAtrac;
		Atraccion atraccAct = null;
		
		try {
			File file = new File(this.ruta);
			scanner = new Scanner(file);
			Promocion promoActual = null;
			
			while(scanner.hasNext())
			{
				nombrePaquete = scanner.next();
				tipoPaquete = scanner.nextInt();
				nombreTipoAtraccion = scanner.next();
				
				tipo = TipoAtraccion.asignarTipo(nombreTipoAtraccion);
				
				switch(tipoPaquete)
				{
					case 1:			//Promocion de tipo ABSOLUTO
						promoActual = new PromocionAbsoluta(nombrePaquete,tipo,scanner.nextInt());
						break;
						
					case 2:			//Promocion de tipo PORCENTUAL
						promoActual = new PromocionPorcentual(nombrePaquete,tipo,scanner.nextDouble());
						break;
						
					case 3:			//Promocion de tipo AxB
						String nombreAtr = scanner.next(); 
						
						atraccAct = Atraccion.buscarAtraccionEnLista(nombreAtr,nombrePaquete, listaAtracciones);
						
						promoActual = new PromocionAxB(nombrePaquete,tipo,atraccAct);
						break;
				}
				
				cantAtracciones = scanner.nextInt();
			
				for(int i=0;i<cantAtracciones;i++)
				{
					nombreAtrac = scanner.next();
					atraccAct = Atraccion.buscarAtraccionEnLista(nombreAtrac,nombrePaquete, listaAtracciones);
					promoActual.addAtraccion(atraccAct);
				}
				promoActual.calcularCosto();
				listaProds.add(promoActual);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			scanner.close();
		}
		return listaProds;
	}

	public LinkedList<Usuario> leerArchivoUsuarios()
	{
		LinkedList<Usuario> colaUsuarios = new LinkedList<Usuario>();
		
		Scanner scanner = null;
		String nombre;
		int presupuesto;
		double tiempoDisp;
		TipoAtraccion preferencia;
		Usuario usuarioAct;
		try
		{
			File file = new File(this.ruta);
			scanner = new Scanner(file);
			
			
			while(scanner.hasNext())
			{
				nombre = scanner.next();
				
				preferencia = TipoAtraccion.asignarTipo(scanner.next());
				
				presupuesto = scanner.nextInt();
				
				tiempoDisp = scanner.nextDouble();
				
				usuarioAct = new Usuario(nombre,presupuesto,tiempoDisp,preferencia);
				
				colaUsuarios.add(usuarioAct);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		return colaUsuarios;
	}

}
