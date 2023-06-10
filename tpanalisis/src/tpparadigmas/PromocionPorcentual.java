package tpparadigmas;

public class PromocionPorcentual extends Promocion {

	private double porcentaje; 
	
	public PromocionPorcentual(String nom, TipoAtraccion tipo, double porc) {
		super(nom, tipo);
		this.porcentaje = porc;
	}

	@Override
	public void calcularCosto() {
		this.costo = this.costoOriginal - (int)(this.costoOriginal * this.porcentaje);
	}
	
}
