package tpparadigmas;

import java.util.LinkedList;

public abstract class Promocion extends Producto {

	protected LinkedList<Atraccion> atracciones;
	protected int costoOriginal;
	// protected boolean sinCupo = false;

	public Promocion(String nom, TipoAtraccion tipo) {
		super(nom, tipo);
		this.atracciones = new LinkedList<Atraccion>();
		this.tiempo = 0;
		this.costoOriginal = 0;
	}

	public void addAtraccion(Atraccion att) {
		this.atracciones.add(att);
		this.tiempo +=att.getTiempo();
		this.costoOriginal += att.getCosto();
	}

	@Override
	public String toString() {
		return "Promocion [atracciones=" + atracciones + ", costoOriginal=" + costoOriginal +
				 ", nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", tipoAtraccion=" + tipoAtraccion
				+ "]";
	}

	public LinkedList<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public void decrementarCupo() {
		atracciones.forEach((att) -> {
			att.decrementarCupo();
		});
	}

	public boolean tieneCupo() {
		for(Atraccion att: atracciones)
		{
			if (!att.tieneCupo()) {
				return false;
			}
		}
		return true;
	}

	public int getCostoOriginal() {
		return this.costoOriginal;
	}

	public abstract void calcularCosto();

}
