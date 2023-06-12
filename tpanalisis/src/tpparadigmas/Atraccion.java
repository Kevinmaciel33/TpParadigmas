package tpparadigmas;

import java.util.LinkedList;

public class Atraccion extends Producto {
	
	protected int cupo;
	
	public Atraccion(String nom, int cost, double time, TipoAtraccion tipo, int cup)
	{
		super(nom, tipo);	
		this.nombre = nom;
		this.costo = cost;
		this.tiempo = time;
		this.cupo = cup;
	}
	
	public void decrementarCupo() {
		this.cupo--;
	}
	
	public boolean tieneCupo() {
		return cupo == 0;
	}
	
	
	public boolean equals(Atraccion otro) {
		return this.nombre == otro.getNombre();
	}
	
	public static Atraccion buscarAtraccionEnLista(String nombreAtr,String nombrePaq,LinkedList<Atraccion> listaAtracciones) throws Exception
	{
		for(Atraccion atraccion:listaAtracciones)
		{
			if(atraccion.getNombre().equals(nombreAtr))
				return atraccion;
		}
		return null;		
	}

	@Override
	public String toString() {
		return "Atraccion [cupo=" + cupo + ", nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo
				+ ", tipoAtraccion=" + tipoAtraccion + "]";
	}
	
}
