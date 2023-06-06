package tpparadigmas;

public class PromocionPorcentual extends Promocion {

	private int porcentaje; 
	
	public PromocionPorcentual(String nom, TipoAtraccion tipo, int porc) {
		super(nom, tipo);
		this.porcentaje = porc;
	}

	@Override
	public void calcularCosto() {
		this.costo = this.costoOriginal - (this.costoOriginal * this.porcentaje);
	}
	
}
