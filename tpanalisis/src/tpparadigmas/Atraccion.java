package tpparadigmas;

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
	
	public boolean sinCupo() {
		return cupo == 0;
	}
	
	public boolean equals(Atraccion otro) {
		return this.nombre == otro.getNombre();
	}
	
}
