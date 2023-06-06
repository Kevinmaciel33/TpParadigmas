package tpparadigmas;

import java.util.LinkedList;

public abstract class Promocion extends Producto {

	protected LinkedList<Atraccion> atracciones;
	protected int costoOriginal;
	protected boolean noHayCupo = false;
	
	public Promocion(String nom, TipoAtraccion tipo) {
		super(nom, tipo);
	}

	public void addAtraccion(Atraccion att) {
		atracciones.add(att);
	}
	
	public LinkedList<Atraccion> getAtracciones() {
		return this.atracciones;
	}
	
	public void decrementarCupo() {
		atracciones.forEach((att) -> {
			att.decrementarCupo();
		});
	}
	
	public boolean sinCupo() {
		if(!this.noHayCupo) {
			atracciones.forEach((att) -> {
				if(att.sinCupo()) this.noHayCupo = true;
			});
		}
		return this.noHayCupo;
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
