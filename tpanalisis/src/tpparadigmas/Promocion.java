package tpparadigmas;

import java.util.LinkedList;

public abstract class Promocion extends Producto {

	protected LinkedList<Atraccion> atracciones;
	protected int costoOriginal;
	protected boolean sinCupo = false;
	
	public Promocion(String nom, TipoAtraccion tipo)
	{
		super(nom, tipo);
		this.atracciones = new LinkedList<Atraccion>();
	}

	public void addAtraccion(Atraccion att) {
		this.atracciones.add(att);
	}
	
	@Override
	public String toString() {
		return "Promocion [atracciones=" + atracciones + ", costoOriginal=" + costoOriginal + ", sinCupo=" + sinCupo
				+ ", nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", tipoAtraccion=" + tipoAtraccion
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
		if(!this.sinCupo) {
			atracciones.forEach((att) -> {
				if(att.sinCupo()) this.sinCupo = true;
			});
		}
		return this.sinCupo;
	}
	
	public void calcularTiempo() {
		atracciones.forEach((att) -> {
			this.tiempo += att.getTiempo();
		});
	}
	
	public void calcularCostoOriginal() {
		atracciones.forEach((att) -> {
			this.costoOriginal += att.getCosto();
		});
	}
	
	public int getCostoOriginal() {
		return this.costoOriginal;
	}
	
	public abstract void calcularCosto();
	
}
